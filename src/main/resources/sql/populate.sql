INSERT INTO public.rol (nombre, descripcion)
VALUES ('ADMIN', 'Administrador'),
       ('USER', 'Usuario');


INSERT INTO public.usuarios (username, documento, telefono, email, nombre, edad, "password", direccion, tipodocumento, rol)
VALUES ('homie.simpson', 123456789, '3174414419', 'homie.simpson@springfield.com', 'Homero J Simpson', 36, '$2a$10$5vSdtayS.aiXtgX5fUSTz.8YMcSypUTuddZeqTKOgfmJ96cSwyxRO', '742 de Evergreen Terrace', 'CC', 1),
       ('montgomery.burns', 987654321, '3075627419', 'montgomery.burns@springfield.com', 'Montgomery Burns', 87, '$2a$10$GbwT0Q/663ZGi8h9TCyMWuiP1Uzl3j.L9h4oJ9eJ0hIZLxeH/Y9vq', 'Mansión Burns', 'CC', 2);


INSERT INTO public.categorias (nombre, descripcion)
VALUES ('Ropa', 'Todos los productos para que estés a la moda.');


INSERT INTO public.productos (categoria, nombre, precio, descripcion, puntaje, cantidad)
VALUES ('Ropa', 'Red Printed T-shirt', 50000, 'Camiseta Roja Lo mas de aleta', 4, 20),
       ('Ropa', 'Zapatillas Negras HRX', 320000, 'Zapatillas negras ultra pelles', 4, 2),
       ('Ropa', 'Pantalon Gris Ultra 4k', 60000, 'Pantalos gris hiper pelle', 4, 43),
       ('Ropa', 'Camisa Polo Azul PUMA', 100000, 'Camisa mas pelle HD', 4, 29),
       ('Ropa', 'Zapatillas Grises PUMA', 520000, 'Zapatillas grises ultra pelles', 4, 45),
       ('Ropa', 'Camisa Negra PUMA', 40000, 'Camisa PUMIX 1080p', 4, 432),
       ('Ropa', 'Medias HRX', 20000, 'Medias Medio Medio', 4, 204),
       ('Ropa', 'Reloj Negro Fossil', 3200000, 'Ultra fino 4k el reloj', 4, 5),
       ('Ropa', 'Reloj Roadster Negro', 1203000, 'Relojito aspero', 4, 54),
       ('Ropa', 'Zapatillas Deportivas HRX', 200000, 'Zapatillas negras ultra pelles', 4, 20),
       ('Ropa', 'Zapatillas Grises HRX', 125999, 'Zapatillas grises ultra pelles', 4, 54),
       ('Ropa', 'Pantalon NIKE negro', 150000, 'Severo Yoger', 4, 20);


INSERT INTO public.imagenes (producto, url)
VALUES (72, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036254/ytnzk8sgwag6scv5rwqe.jpg'),
       (72, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036255/gjyiaozbezp7sh6lppna.jpg'),
       (72, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036256/abxrcwtex9uo4yivq3jy.jpg'),
       (72, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036257/zr6qcbrnxbxf4iszkfrn.jpg'),
       (72, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036258/mukr903y10kntpkfvmsk.jpg'),
       (73, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036259/ffywg5pul0xpyuwkvmca.jpg'),
       (73, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036260/a2sa6i0totouz908jw3q.jpg'),
       (73, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036262/lnmmic7bcrunscuvycub.jpg'),
       (73, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036264/dwi1kknipo9z2vddd2jr.jpg'),
       (73, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036265/grx6pakqn8hsocepjd9i.jpg'),
       (74, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036266/pdcerwoup0ckmcnv2nkc.jpg'),
       (74, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036268/o4srglzelecjzzh0s2vp.jpg'),
       (74, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036269/olulzy5nqtkkhymgen4r.jpg'),
       (74, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036270/jw4y2u8syas8tdbossxi.jpg'),
       (74, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036272/cgudgtmeabyg6kvqeujm.jpg'),
       (75, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036273/zmrdrffna9j1bpn6gp6d.jpg'),
       (75, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036274/po0kmvn5hnrcxz9dzthe.jpg'),
       (75, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036276/lhakdgxkznf3joyt5bc9.jpg'),
       (75, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036277/pxnk7xsnd3aculfhl2qg.jpg'),
       (75, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036279/g9gnzjgwbyab5do3xgjc.jpg'),
       (76, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036280/wtyvezbe6fle4oxenfje.jpg'),
       (76, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036282/naayxvadbwdlkdvhgwmr.jpg'),
       (76, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036284/f4d2nn6fgy9nzhtmt5qv.jpg'),
       (76, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036286/czhudjnzhviiffonj5ut.jpg'),
       (76, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036288/daot08jiole60ghvple4.jpg'),
       (77, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036289/thafzzs0ltdifyody3q7.jpg'),
       (77, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036290/izr7p6qtsxwbw6rd7oue.jpg'),
       (77, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036292/mqrxm9jga27602uegnfj.jpg'),
       (77, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036293/obzxsyjd5wvwf2jpbars.jpg'),
       (77, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036295/vusgornz2ejg0s1ctbyf.jpg'),
       (78, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036296/cswh0earqygrafwzug1l.jpg'),
       (78, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036297/tfwpi4i7y4g9wuetf3qq.jpg'),
       (78, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036298/icw4v8gzntkdb2iusgn1.jpg'),
       (78, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036300/pi1sruejzauwtiaqz2mt.jpg'),
       (78, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036301/eaw8y174yaqqshlgithx.jpg'),
       (79, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036303/cn6cjxiyjtso2mh97cfz.jpg'),
       (79, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036304/vtkzwrmptohwaijehtmk.jpg'),
       (79, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036305/gybie4lbrzexrvvsro0c.jpg'),
       (79, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036306/zkfqiocx9ox6re3fawtz.jpg'),
       (79, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036307/fgqtd8bslxwhtbrorodf.jpg'),
       (80, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036308/yy2fk88o8e6ygxgwy2oq.jpg'),
       (80, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036309/cvhbobzkvmou1kn8hyli.jpg'),
       (80, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036311/cia9bt4ij14l12alkeg2.jpg'),
       (80, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036312/kfetdfofebhehdwr7pn1.jpg'),
       (80, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036313/vhaksckplrzw4jheexju.jpg'),
       (81, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036315/c88poj1pxggkg42brefv.jpg'),
       (81, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036316/ao7cf2xg3s6cla7v8f0d.jpg'),
       (81, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036317/sns14teopsaqi4xyulxa.jpg'),
       (81, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036319/ojzlzbkidy0if6rqrirq.jpg'),
       (81, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036320/swkm4w6stipg5z33pjwf.jpg'),
       (82, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036321/owsrqvywu849mm0vneya.jpg'),
       (82, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036323/yiopcq0rzwoenw39x4oy.jpg'),
       (82, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036324/nk5jwbtc7ynhm6j89xhq.jpg'),
       (82, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036325/vrlhjaz6wdtivxfocmoo.jpg'),
       (82, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036327/vy7wmqr9dpjrjteluiwp.jpg'),
       (83, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036329/nan7topi4ul0iqzhjmly.jpg'),
       (83, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036330/jym0iixo5pb41dyqgbmp.jpg'),
       (83, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036331/nulw4idcqjvc6gncvlwb.jpg'),
       (83, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036333/ykns0zt2znjribkpw5fn.jpg'),
       (83, 'https://res.cloudinary.com/t6fd7g1u/image/upload/v1617036334/xpz2crzwee0wramq0xpp.jpg');