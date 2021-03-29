package edu.escuelaing.arsw.markethub.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.persistence.Persistence;

@Component
public class TempInsert {

    @Autowired
    @Qualifier("myBatisPersistence")
    Persistence persistence;

    public void registerToTheGrandDatabase(Integer id, Categoria categoria, String nombre, List<String> imagenes,
            Integer precio, String descripcion, Double puntaje, Integer cantidad) throws IOException {

        ArrayList<File> binImgs = new ArrayList<>();
        ArrayList<Imagen> MHImgs = new ArrayList<>();
        Producto prod = new Producto(id, categoria, nombre, new ArrayList<Imagen>(), precio, descripcion, puntaje,
                cantidad);

        File img;
        for (String imgPath : imagenes) {
            imgPath = imgPath.replace("../", "static/");
            ClassLoader classLoader = getClass().getClassLoader();

            img = new File(classLoader.getResource(imgPath).getFile());
            binImgs.add(img);

            Imagen imagencita = new Imagen();
            imagencita.setProductoId(prod.getId());
            // imagencita.setImagen(FileUtils.readFileToByteArray(img));
            MHImgs.add(imagencita);
        }

        id = persistence.registerProduct(prod);
        prod.setId(id);
        for (int i = 0; i < binImgs.size(); i++) {
            System.out.println("ID: " + persistence.insertImage(binImgs.get(i), MHImgs.get(i)));
        }
    }

    public void insert() throws IOException {

        Categoria categoria = new Categoria("Ropa", "Todos los productos para que estés a la moda.");
        // persistence.insertCategory(categoria);

        ArrayList<String> imagenes = new ArrayList<>();
        imagenes.add("../images/product-1.jpg");
        imagenes.add("../images/gallery-1.jpg");
        imagenes.add("../images/gallery-2.jpg");
        imagenes.add("../images/gallery-3.jpg");
        imagenes.add("../images/gallery-4.jpg");
        registerToTheGrandDatabase(1, categoria, "Red Printed T-shirt", imagenes, 50000,
                "Camiseta Roja Lo mas de aleta", 4.0, 20);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        registerToTheGrandDatabase(2, categoria, "Zapatillas Negras HRX", imagenes, 320000,
                "Zapatillas negras ultra pelles", 3.5, 2);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        registerToTheGrandDatabase(3, categoria, "Pantalon Gris Ultra 4k", imagenes, 60000, "Pantalos gris hiper pelle",
                4.5, 43);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        registerToTheGrandDatabase(4, categoria, "Camisa Polo Azul PUMA", imagenes, 100000, "Camisa mas pelle HD", 4.0,
                29);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        registerToTheGrandDatabase(5, categoria, "Zapatillas Grises PUMA", imagenes, 520000,
                "Zapatillas grises ultra pelles", 4.0, 45);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        registerToTheGrandDatabase(6, categoria, "Camisa Negra PUMA", imagenes, 40000, "Camisa PUMIX 1080p", 3.5, 432);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        registerToTheGrandDatabase(7, categoria, "Medias HRX", imagenes, 20000, "Medias Medio Medio", 4.5, 204);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        registerToTheGrandDatabase(8, categoria, "Reloj Negro Fossil", imagenes, 3200000, "Ultra fino 4k el reloj", 4.0,
                5);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        registerToTheGrandDatabase(9, categoria, "Reloj Roadster Negro", imagenes, 1203000, "Relojito aspero", 4.0, 54);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        registerToTheGrandDatabase(10, categoria, "Zapatillas Deportivas HRX", imagenes, 200000,
                "Zapatillas negras ultra pelles", 4.5, 20);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        registerToTheGrandDatabase(11, categoria, "Zapatillas Grises HRX", imagenes, 125999,
                "Zapatillas grises ultra pelles", 4.5, 54);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        registerToTheGrandDatabase(12, categoria, "Pantalon NIKE negro", imagenes, 150000, "Severo Yoger", 4.0, 20);
    }
}
