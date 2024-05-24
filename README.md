# RetoScreenPlayDemoQa
automatización en screen play
este proyecto fue creado en screen play java, en el ide intelliji
para poder ejecutarlo deben tener configurada la maquina, la instalacion de java (JDK), haber configurado variable de entorno java, asi como la instalacion y configuradcion de variable de entorno gradle tambien.
ya teniendo la maquina configurada, hay que descargar el proyecto en el computador
despues desde intelliji dar clic en la opcion:"file", despues en la opcion: "new", despues en la opcion "Project for eisting sources", despues selecciona la carpeta del proyecto en la ubuicacion en la que fue guardada,
despues se selecciona la opcion "Gradle" y por ultimo se le da a ok.
Despues de haber abierto el proyecto en intelliji se debe colocar a compilar para que descargue todas las dependencias, librerias etc,
si no compila puede ser porque no se este utilizando una version de java o gradle compatible, o porque en el proyeto en general no se le seleccion el java correcto para la compilacion, hay que verificar estos items.
cuando ya el proyecto haya compilado correctamente hay que validar la version de chrome y compararla con el chromedriver que se tiene.
cuando vayamos a ejecutar el proyecto debemos ir al runner, ejecutar cualquier de los dos de pendiendo el flujo que se quiera probar, dando clic derecho sobre alguna de las clases runner y despues dandole clic en ejecutar.
