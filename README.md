# WarehouseInventoryManagementSystem

A modular Java 17 application for managing warehouse inventory, orders and shipping in a real-world logistics context. The system demonstrates industry-grade design through the application of core Gang of Four patterns, making it easy to extend, test and maintain.

---

## 🏆 Purpose

- **Centralize configuration** (thresholds, API URLs, credentials) in a single, thread-safe service.  
- **Manage products** and quickly clone “templates” without rebuilding every field.  
- **Build complex orders** step-by-step, with optional fields (customer, items, delivery date, instructions).  
- **Select shipping services** dynamically (ground, air, express) without coupling business logic to concrete classes.  
- **Expose a clean API** façade that hides the complexity of inventory reservation, order persistence and shipping.  
- **Cache stock queries** to reduce backend load and improve performance.  
- **Support multiple replenishment policies** (average usage, peak demand) that can be swapped at runtime.  
- **Orchestrate order processing** via a chain of independent handlers (validation, logging, notification).

---

## 🚀 Key Features & Design Patterns

| Module                     | Pattern                  | What It Solves                                              |
| -------------------------- | ------------------------ | ----------------------------------------------------------- |
| `config-service`           | **Singleton**            | Single source of global configuration                       |
| `product-core`             | **Prototype**            | Cloneable product templates                                 |
| `order-builder`            | **Builder**              | Construct orders with optional fields in a fluent API       |
| `shipping-factory`         | **Factory Method**       | Decouple shipping selection (ground, air, express)          |
| `inventory-facade`         | **Facade**               | Unified REST API for the full inventory→order→shipping flow |
| `inventory-proxy`          | **Proxy**                | In-memory cache for stock level queries                     |
| `replenishment-strategy`   | **Strategy**             | Pluggable reorder quantity algorithms                       |
| `processing-pipeline`      | **Chain of Responsibility** | Sequential, extensible order validation & notification      |

---

## 📦 Modules

- **config-service**  
- **product-core**  
- **order-builder**  
- **shipping-factory**  
- **inventory-facade**  
- **inventory-proxy**  
- **replenishment-strategy**  
- **processing-pipeline**

Each module has its own `pom.xml` and encapsulates a single pattern and related functionality.

---

## 🔧 Getting Started

1. **Clone the repo**  
   ```bash
   git clone https://github.com/yourorg/WarehouseInventoryManagementSystem.git
   cd WarehouseInventoryManagementSystem
