INSERT INTO public.rol(nombre, descripcion) VALUES
	('ADMIN', 'Administrador'),
	('USER', 'Usuario');

INSERT INTO public.usuarios (username,documento,telefono,email,nombre,edad,"password",direccion,"tipodocumento",rol) VALUES
	 ('homie.simpson',123456789,'3174414419','homie.simpson@springfield.com','Homero J Simpson',36,'$2a$10$5vSdtayS.aiXtgX5fUSTz.8YMcSypUTuddZeqTKOgfmJ96cSwyxRO','742 de Evergreen Terrace','CC',1),
	 ('montgomery.burns',987654321,'3075627419','montgomery.burns@springfield.com','Montgomery Burns',87,'$2a$10$GbwT0Q/663ZGi8h9TCyMWuiP1Uzl3j.L9h4oJ9eJ0hIZLxeH/Y9vq','Mansión Burns','CC',2);