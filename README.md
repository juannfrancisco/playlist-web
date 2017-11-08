# Playlist

Administrar playlist de musica


* Login
* Definición de Perfiles



## Login

* [Diagrama de Clases](#diagrama-de-clases)
* Diagrama de Secuencia
* Diagrama de Entidad/Relacion
* Intefaz Grafica

### Diagrama de Clases

![alt text](https://raw.githubusercontent.com/juannfrancisco/playlist-web/master/diagramas/diagrama-clases.png "Diagrama de Clases")


### Diagrama de Secuencia

![alt text](https://raw.githubusercontent.com/juannfrancisco/playlist-web/master/diagramas/diagrama-login.png "Diagrama de Clases")


### Diagrama de Entidad/Relacion


![alt text](https://raw.githubusercontent.com/juannfrancisco/playlist-web/master/db-scripts/diagrama-er.png "Diagrama de Clases")




### Interfaz Grafica

#### Inicio de Sesión

![alt text](https://raw.githubusercontent.com/juannfrancisco/playlist-web/master/ui/ui-login.png "Diagrama de Clases")

#### Pantalla Inicial

![alt text](https://raw.githubusercontent.com/juannfrancisco/playlist-web/master/ui/ui-pantalla-inicio.png "Diagrama de Clases")




## Definición de Perfiles

A continuación de detalla todos los perfiles y los perfiles que tienen acceso cada uno.

| Perfil        | Permisos                    |
| ------------- |-----------------------------|
| Cliente       | nueva-playlist              |
|               | ver-mi-playlist             |
|               | eliminar-playlist           |
|               | agregar-cancion-playlist    |
|               | eliminar-cancion-playlist   |
|               | ver-canciones               |
| Administrador | crear-cancion               |
|               | ver-canciones               |
|               | ver-usuarios                |
|               | eliminar-usuario            |
