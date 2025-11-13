# SAUCEDEMO AUTOMATION PROJECT
## Prueba E2E con Serenity BDD, Screenplay y Cucumber

### TECNOLOGÍAS Y VERSIONES UTILIZADAS
- Java JDK: 11 o superior
- Maven: 3.6.3 o superior
- Serenity BDD: 4.0.40
- Cucumber: 7.14.0
- Selenium WebDriver: Incluido en Serenity
- ChromeDriver: Se descarga automáticamente via WebDriverManager

### PRERREQUISITOS
1. Instalar Java JDK 11 o superior
   - Verificar instalación: `java -version`
   - Descargar desde: https://adoptium.net/

2. Instalar Maven
   - Verificar instalación: `mvn -version`
   - Descargar desde: https://maven.apache.org/download.cgi

3. Instalar Google Chrome (última versión)
   - El ChromeDriver se gestiona automáticamente

### INSTRUCCIONES DE EJECUCIÓN

#### PASO 1: Compilar el proyecto
```bash
mvn clean compile
```
Este comando:
- Limpia compilaciones anteriores
- Descarga todas las dependencias
- Compila el código fuente

#### PASO 2: Ejecutar las pruebas
```bash
mvn clean verify
```
Este comando:
- Ejecuta las pruebas de integración
- Genera reportes de Serenity
- Los resultados se guardan en `target/site/serenity/`

#### PASO 3: Ver los reportes
```bash
# Abrir el reporte en el navegador
# Windows:
start target/site/serenity/index.html

# Mac:
open target/site/serenity/index.html

# Linux:
xdg-open target/site/serenity/index.html
```

### COMANDOS ADICIONALES

#### Ejecutar solo tests con tag específico
```bash
mvn verify -Dcucumber.filter.tags="@Smoke"
```

#### Ejecutar en modo headless (sin interfaz gráfica)
```bash
mvn verify -Dheadless.mode=true
```

#### Limpiar reportes anteriores
```bash
mvn clean
```

### ESCENARIO DE PRUEBA
El escenario automatizado realiza:
1. Navegación a https://www.saucedemo.com/
2. Login con usuario: standard_user / password: secret_sauce
3. Agregar 2 productos al carrito:
   - Sauce Labs Backpack
   - Sauce Labs Bike Light
4. Visualizar el carrito
5. Completar formulario de checkout:
   - First Name: Juan
   - Last Name: Pérez
   - Postal Code: 12345
6. Finalizar la compra
7. Validar mensaje: "Thank you for your order!"


