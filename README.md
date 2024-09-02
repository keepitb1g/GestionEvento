# Gestión de Acceso a Eventos

## Descripción

Este proyecto gestiona el acceso a eventos, permitiendo agregar y verificar personas, controlar el aforo disponible, y validar los requisitos de ingreso. Está diseñado para manejar una lista de hasta 10 personas, cada una con 5 datos: nombre, edad, tipo de boleto, número de invitados y estado de ingreso.

## Métodos Principales

1. **`agregarPersona(String[][] lista, String nombre, String edad, String boleto, String invitados, String ingresado)`**  
   Agrega una persona a la lista con los datos especificados. Solo se añade a la primera fila vacía disponible.

2. **`crearLista()`**  
   Inicializa la lista de personas con datos predefinidos. Es utilizada para restablecer la lista a su estado inicial.

3. **`verificarEdad(String[][] lista, String nombre)`**  
   Verifica si una persona es mayor de edad buscando por su nombre. Retorna `true` si es mayor de 18 años, `false` en caso contrario.

4. **`verificarBoleto(String[][] lista, String nombre)`**  
   Devuelve el tipo de boleto de una persona (VIP, General o None) buscando por su nombre. Si no encuentra el nombre, retorna "Error buscando el boleto."

5. **`validarInvitados(String[][] lista, String nombre)`**  
   Verifica si una persona con boleto VIP cumple con los requisitos para traer invitados, buscando por su nombre. Retorna "Permitido" si puede traer hasta 2 invitados o "Excede el máximo de invitados para el boleto VIP" si supera este límite.

6. **`aforoDisponible(String[][] lista, int aforo)`**  
   Calcula el aforo disponible:
   - Con `aforo = 10`, devuelve el aforo disponible para entradas Generales.
   - Con `aforo = 15`, devuelve el aforo disponible para entradas VIP, considerando el número de invitados.

7. **`ingresoPersona(String[][] lista, String nombre)`**  
   Marca a una persona como ingresada al evento buscando por su nombre, cambiando su estado de "False" a "True".

8. **`permitirAcceso(String[][] lista, int numeroFila)`**  
   Verifica si una persona cumple con todos los requisitos para entrar al evento, incluyendo la verificación de edad, tipo de boleto y aforo disponible, buscando por la posición en la lista (índice de 0 a 9).

9. **`removerPersona(String[][] lista, String nombre)`**  
   Marca a una persona como no ingresada dentro del evento, buscando por su nombre y cambiando su estado de "True" a "False".

## Pruebas Unitarias

El archivo de pruebas unitarias incluye tests para cada uno de los métodos, asegurando su correcto funcionamiento. También incluye un test que evalúa múltiples métodos en simultáneo para validar la integración entre ellos.
