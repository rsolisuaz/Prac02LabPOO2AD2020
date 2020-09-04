# PRÁCTICA 2. EXPRESIONES REGULARES Y COLECCIONES.

## COPIA DEL REPOSITORIO REMOTO EN SU COMPUTADORA LOCAL
Como primer paso, será necesario crear una copia local del repositorio remoto creado en Github al aceptar la tarea. Para ello, es necesario hacer los siguientes pasos:
1)	Entrar a la página cuyo URL les fue proporcionado al aceptar la tarea, en tal página dé click en el botón Code y copie el URL que aparece en el cuadro de texto de nombre **Clone with HTTPS** (comienza con *https://*)
2)	En una consola de Git Bash en Windows (o en una terminal en Linux o Mac), cree una carpeta donde quiera que se contengan sus prácticas del semestre (si es que aún no la has creado) y colócate en tal carpeta. La carpeta la puedes crear desde el Git Bash o terminal Linux/Mac usando el comando `mkdir` (o con el explorador de archivos de su sistema operativo) y en la consola de Git Bash o terminal de Linux/Mac te puedes cambiar a la carpeta mencionada usando el comando `cd`
3)	Clone el repositorio privado dando el comando `git clone URL practica02`
 (donde **URL** es el URL que copió en el paso 1)\
 Este comando creará dentro de la carpeta creada en el paso 2) una subcarpeta de nombre **practica02** donde estará una copia local del repositorio remoto.\
 Los comandos posteriores de git tendrán que darse desde tal carpeta, por tanto, cámbiate a la carpeta usando `cd practica02`


## MODIFICACIÓN DEL CÓDIGO PROPORCIONADO
Una vez que tengas el repositorio local, tu trabajo consiste en completar los métodos **obtenAlfabeticamenteGlobal**, **obtenPorLongitudDescGlobal** y **obtenAlfabeticoPorLinea**  de la clase **ExpRegSearcher**, proporcionada en el repositorio privado que se creó al aceptar esta tarea.

Tales métodos tendrán como trabajo buscar un patrón (expresión regular) en un ArrayList de líneas de texto y regresar un ArrayList con los Strings que concuerdan con tal patrón. Tal ArrayList deberá tener un orden específico, **obtenAlfabeticamenteGlobal** ordena todos los Strings que concuerdan en todas las líneas alfabeticamente por orden ascendente, **obtenPorLongitudDescGlobal** ordena todos los Strings que concuerdan en todas las líneas por longitud descendente, es decir, del String más largo al más corto, y finalmente **obtenAlfabeticoPorLinea** ordena todos los Strings que concuerdan en todas las líneas alfabeticamente por orden ascendente, pero agrupándolos por línea, es decir, en el ArrayList resultante quedan primero todos los Strings que concordaron de la primera línea ordenados de manera ascendente, después todos los Strings que concuerdan en la segunda línea ordenados de manera ascendente y así sucesivamente.

**NOTA IMPORTANTE**: En los casos que se menciona que se desea el resultado en orden alfabético tome en cuenta que en caso de que en el resultado haya una mezcla de mayúsculas y minúsculas primero aparecerán las mayúsculas y posteriormente las minúsculas (comportamiento por default al ordenar Strings)

En el código que se te proporciona como base, ya se encuentra implementada toda la lógica para leer las líneas de la entrada e imprimir el resultado que devuelven los métodos arriba mencionados por lo cual no debes preocuparte en escribir el código para leer los datos e imprimir los resultados.

La entrada se asume tendrá siempre la siguiente estructura, y por tanto no es necesario validarla:
a)	La primera línea que se dé en la entrada contiene la expresión regular a buscar. A partir de la segunda línea en adelante, cada línea de entrada representa un texto donde se buscará la expresión regular. Una línea vacía indica que ya no hay mas líneas por leer y hace que el programa termine de leer líneas.

En el método *procesaEntrada* se hace todo el trabajo de leer las líneas de entrada, creando un objeto Pattern para representar la expresión regular de la primera línea y colocando todas las restantes líneas  en un ArrayList. También, una vez leída todas las líneas entrada, llama al método que corresponde para obtener el resultado de acuerdo al argumento que se le pase al programa, que puede ser alguno de los que se mencionan a continuación. 

1. Si el programa se manda llamar con el argumento -l de la siguiente manera:
   ```
   java ExpRegSearcher -l
   ```
   El resultado que genera debe ser en orden por longitud descendente (de la cadena mas larga a la mas corta)
   
2. Si el programa se manda llamar con el argumento -p de la siguiente manera:
   ```
   java ExpRegSearcher -p
   ```
   El resultado que genera debe ser en orden alfabético ascendente agrupado por línea 
   
3. Si el programa se manda llamar sin argumentos o con el argumento -a de la siguiente manera:
   ```
   java ExpRegSearcher
   ```
   o
   ```
   java ExpRegSearcher -a
   ```
   El resultado que genera debe ser en orden alfabético ascendente

En caso de que la expresión regular dada en la primera línea de entrada tenga errores, el código que se proporciona en el método procesaEntrada se dará cuenta de ello e imprimirá el siguiente mensaje de error: `ERROR EN EXPRESION REGULAR` 

## Ejemplos

En los siguientes ejemplos, la primera `línea` representa como se llamaría al programa, las subsecuentes líneas en **negrita** representa lo que se teclea de entrada (terminada con una línea en blanco), y después de la línea en blanco, con letras en *itálico* se muestra la salida correspondiente. En los tres ejemplos, la expresión regular dada como primera línea de entrada representa una palabra completa compuesta de solo letras de la a a la z minúsculas (y con una longitud mínima de 1 letra)

1. Para generar el resultado en orden alfabético ascendente:

```
java ExpRegSearcher
```
**\b[a-z]+\b\
-Hola Ernesto, como te va?\
-Pues me va, y a ti, Jose?\
-No me quejo, pero ya que se acabe el Covid.\
-Si, estaria excelente eso.\
-Hasta luego.\
-Sale, ahi te ves.**


*a\
acabe\
ahi\
como\
el\
eso\
estaria\
excelente\
luego\
me\
me\
pero\
que\
quejo\
se\
te\
te\
ti\
va\
va\
ves\
y\
ya*


2. Para generar el resultado en orden por longitud descendente (de cadena más larga a la más corta):
```
java ExpRegSearcher -l
```
**\b[a-z]+\b\
-Hola Ernesto, como te va?\
-Pues me va, y a ti, Jose?\
-No me quejo, pero ya que se acabe el Covid.\
-Si, estaria excelente eso.\
-Hasta luego.\
-Sale, ahi te ves.**

*excelente\
estaria\
quejo\
acabe\
luego\
como\
pero\
que\
eso\
ahi\
ves\
te\
va\
me\
va\
ti\
me\
ya\
se\
el\
te\
y\
a*



3. Para generar el resultado en orden alfabético ascendente agrupado por línea:
```
java ExpRegSearcher -p
```
**\b[a-z]+\b\
-Hola Ernesto, como te va?\
-Pues me va, y a ti, Jose?\
-No me quejo, pero ya que se acabe el Covid.\
-Si, estaria excelente eso.\
-Hasta luego.\
-Sale, ahi te ves.**


*como\
te\
va\
a\
me\
ti\
va\
y\
acabe\
el\
me\
pero\
que\
quejo\
se\
ya\
eso\
estaria\
excelente\
luego\
ahi\
te\
ves*



NOTEN QUE EN ESTE ÚLTIMO EJEMPLO, PRIMERO APARECEN LOS STRING QUE CONCUERDAN DE LA PRIMERA LÍNEA (**-Hola Ernesto, como te va?**), QUE SON **como**, **te** y **va** ORDENADOS DE MANERA ASCENDENTE. DESPUÉS APARECEN LOS STRING QUE CONCUERDAN DE LA SEGUNDA LÍNEA (**-Pues me va, y a ti, Jose?**), QUE SON **me**, **va**, **y** **a** y **ti** ORDENADOS DE MANERA ASCENDENTE, Y ASÍ SUCESIVAMENTE. 

## CALIFICACIÓN
Cada uno de los métodos que debes implementar de la clase **ExpRegSearcher** aporta parte de la calificación:

1. **obtenAlfabeticamenteGlobal** aporta **60 puntos**
2. **obtenPorLongitudDescGlobal** aporta **40 puntos**
3. **obtenAlfabeticoPorLinea** aporta **20 puntos**

Dando un **total de 120 puntos**. **SI SU PROGRAMA NO COMPILA OBTENDRÁ CERO PUNTOS**

**RECUERDA QUE SOLO DEBES HACER CAMBIOS EN LOS TRES MÉTODOS MENCIONADOS, NO DEBES CAMBIAR NINGUNA OTRA PARTE DEL CÓDIGO (DE HECHO, DONDE TU DEBES ESCRIBIR CÓDIGO ESTA MARCADO CON UN COMENTARIO `//TODO` )** 

## NOTAS IMPORTANTES
**SI NECESITAS HACER CLASES EXTRA PARA SOLUCIONAR LA PRACTICA, ASEGURATE DE COLOCARLAS EN EL ARCHIVO ExpRegSearcher.java , SI DECIDES PONERLAS EN ARCHIVOS SEPARADOS NO OLVIDES AGREGAR TALES ARCHIVOS CON `git add` ANTES DE HACER EL COMMIT CORRESPONDIENTE**

1. Recuerda que de acuerdo a lo visto en la Práctica 1, el proceso que debes estar haciendo es:
   - Haz cambios  en el archivo fuente **ExpRegSearcher.java** (y/o en algún otro archivo Java auxiliar si así lo requieres)
   - **Compila y ejecuta el programa en tu computadora para ver que realiza lo que quieres de acuerdo a los cambios que realizaste en el código** (trata de ir haciendo cambios incrementales, por ejemplo, completa uno de los métodos primero y prueba que funcione antes de hacer cambios en los otros métodos)
   - Si ya compila y corre correctamente avisa a tu repositorio local que registre esos cambios dando los comandos `git add ExpRegSearcher.java` y `git commit -m "MENSAJE"` donde MENSAJE es un texto que describe brevemente, pero de manera clara los cambios que realizaste desde el último commit. **NOTA:** Si decides crear archivos Java adicionales a **ExpRegSearcher.java** y le hiciste cambios después del último commit que habías hecho también debes notificar a tu repositorio local que lo tome en cuenta con  en el comando `git add`

2. Después de haber hecho todos los commits que completan tu programa, súbelo al repositorio remoto dando `git push`

3. Cada vez que hagas `git push` se realizarán automáticamente pruebas sobre tu código para verificar si funciona correctamente. Recuerda que en la página de tu repositorio en la sección **Pull Requests**, se encuentra una subsección de nombre **Feedback**, donde podrás encontrar los resultados de las pruebas en la pestaña denominada **Check** (expandiendo la parte que dice **Run education/autograding@v1**), y cualquier comentario general que el profesor tenga sobre tu código en la pestaña **Conversation**. 
