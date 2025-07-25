🐾 Gestor de Mascotas - Aplicación con Swing, DAO y Singleton
Este proyecto es una aplicación de escritorio construida en Java con Swing, que implementa una gestión básica de mascotas en una clínica veterinaria. Se utilizan los patrones de diseño DAO, DTO y Singleton, junto con serialización de datos para almacenamiento local en archivos .dat.

🎯 Objetivos del Proyecto
Implementar el patrón Singleton en la clase de persistencia.

Aplicar el patrón DAO para encapsular la lógica de acceso a datos.

Crear una interfaz gráfica funcional con Swing.

Validar datos mediante excepciones personalizadas.

Almacenar datos en archivos binarios para persistencia.



🧱 Estructura del Proyecto

src/
│
├── dao/                    # Lógica de acceso a datos
│   └── MascotaDAO.java
│
├── dto/                    # Transferencia de datos
│   └── MascotaDTO.java
│
├── exception/              # Excepciones personalizadas
│   └── DatoInvalidoException.java
│
├── persistence/            # Persistencia y Singleton
│   └── GestorPersistencia.java
│
├── view/                   # Interfaz gráfica Swing
│   └── FormMascota.java
│
└── Main.java               # Punto de entrada

🚀 ¿Cómo Ejecutar?
Asegúrate de tener Java 8+ instalado.

Compila todos los archivos .java:

javac Main.java
Ejecuta el programa:

java Main
🖥️ Funcionalidades
✅ Registrar una nueva mascota
✅ Mostrar listado de mascotas en tabla (JTable)
✅ Eliminar o actualizar una mascota seleccionada
✅ Validación de campos: nombre, especie y edad
✅ Persistencia de datos en archivo local (mascotas.dat)
✅ Patrón Singleton garantiza una sola instancia de GestorPersistencia y MascotaDAO

📌 Patrones de Diseño Usados
Singleton
Aplicado en:

GestorPersistencia → Centraliza y limita la instancia de acceso a archivos

MascotaDAO → Se mantiene una única instancia DAO compartida

DAO (Data Access Object)
MascotaDAO.java maneja lectura/escritura sin mezclar con la lógica de interfaz.

DTO (Data Transfer Object)
MascotaDTO.java encapsula los datos de las mascotas.

🔐 Validación y Excepciones
Se valida que todos los campos estén completos y que la edad sea un número positivo.

En caso de error, se lanza una excepción personalizada: DatoInvalidoException.

🧭 Flujo General de la Aplicación
El usuario llena los campos y presiona Guardar

Se crea un MascotaDTO validado

Se guarda usando MascotaDAO, que delega a GestorPersistencia (Singleton)

Los datos se serializan en mascotas.dat

Al iniciar o modificar, se carga la lista y se muestra en la tabla (JTable)

🛠️ Recomendaciones de Uso
No modificar el constructor de clases Singleton.

Siempre usar getInstancia() para acceder al DAO o gestor.

Evitar incluir lógica de guardado directamente en la interfaz (FormMascota).

Documentar las clases y mantener responsabilidades separadas.

👨‍💻 Autor
Desarrollado por Juan Guillermo Salazar
💡 Taller práctico: Aplicación del Patrón Singleton con DAO y Swing
📅 Fecha: Julio 2025

