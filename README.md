## Berretacoin - Sistema de Gestión de Criptomonedas
Este trabajo consiste en la implementación del TAD Berretacoin, un sistema de gestión de transacciones para una criptomoneda diseñada bajo los requerimientos de un grupo ficticio llamado "Los Berreteros".
El desafío principal consistió en cumplir con restricciones de complejidad temporal estrictas utilizando únicamente estructuras de datos implementadas desde cero.

## 🚀 Características y Funcionalidades
El sistema permite gestionar usuarios y bloques de transacciones con las siguientes operaciones:

Gestión de Usuarios: Creación y seguimiento de saldos para $P$ usuarios.

Gestión de Bloques: Registro de secuencias de transacciones.

Análisis de Datos: Identificación del máximo tenedor de monedas y cálculo de montos medios.

Hackeo de Transacciones: Una funcionalidad especial para extraer la transacción de mayor valor del último bloque.

## 🛠️ Estructuras de Datos Utilizadas
Para cumplir con las complejidades exigidas, se implementaron las siguientes estructuras desde cero (sin utilizar el java.util de la biblioteca estándar):

Heap (Max-Heap): Utilizado para obtener el usuario con más saldo y la transacción de mayor valor en tiempo constante $O(1)$ y actualizar valores en $O(\log n)$.

Lista Doblemente Enlazada: Utilizada para mantener el orden de las transacciones y permitir eliminaciones eficientes.

Sistema de Handles (Punteros): Se implementó una interfaz HandleSupport que permite a los objetos conocer su posición dentro del Heap o la Lista. Esto permite que la operación de eliminación o actualización de un elemento sea extremadamente eficiente.

## 📊 Complejidad Temporal
A continuación se detallan las complejidades logradas (donde $P$ es la cantidad de usuarios y $n_b$ es la cantidad de transacciones en el último bloque):

| Operación | Complejidad Requerida | Implementación y Justificación |
| :--- | :---: | :--- |
| `nuevoBerretacoin` | $O(P)$ | Se inicializan $P$ usuarios y se realiza un *heapify* del arreglo completo. |
| `agregarBloque` | $O(n_b \cdot \log P)$ | Se procesan $n_b$ transacciones. Por cada una, se actualizan los saldos en el Heap de usuarios en tiempo logarítmico. |
| `txMayorValorUltimoBloque` | $O(1)$ | Acceso directo a la raíz del Max-Heap de transacciones del último bloque. |
| `txUltimoBloque` | $O(n_b)$ | Recorrido lineal de la lista enlazada para copiar las transacciones. |
| `maximoTenedor` | $O(1)$ | Acceso directo a la raíz del Max-Heap de usuarios. |
| `montoMedioUltimoBloque` | $O(1)$ | Se mantiene un acumulador de montos y un contador de transacciones actualizados en tiempo real. |
| `hackearTx` | $O(\log n_b + \log P)$ | Extracción del máximo del Heap de transacciones $O(\log n_b)$ y actualización de saldos en el Heap de usuarios $O(\log P)$. |

## 📁 Estructura del Proyecto
Berretacoin.java: Clase principal que orquestra el sistema.

Bloque.java: Gestiona el conjunto de transacciones de un bloque utilizando un Heap y una Lista.

Usuarios.java: Administra el saldo de los usuarios mediante un Heap.

Heap.java & ListaEnlazada.java: Implementaciones genéricas de las estructuras de soporte.

HandleSupport.java: Interfaz para la gestión de punteros internos (Handles).

Transaccion.java & Usuario.java: Clases de dominio del problema.

## ⚖️ Normativa de Implementación
Este proyecto fue desarrollado bajo las siguientes restricciones pedagógicas:

Prohibido el uso de bibliotecas estándar (excepto ArrayList, String y StringBuffer).

Implementación manual de toda la lógica de estructuras de datos (rebalanceos, inserciones, eliminaciones).

Respetar la abstracción y el encapsulamiento de cada componente.

--

*Este proyecto fue realizado para la materia Algoritmos y Estructuras de Datos - DC, UBA (2025).*
