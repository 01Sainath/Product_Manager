# ProdManager Inventory Management

## Overview

ProdManager is a Spring Boot-based product management system designed to streamline the inventory and organization of products. Whether you're managing a floral shop, eco-friendly products, or any other inventory, ProdManager is here to help.

## Features

- **Product List:** Check all the products and its availablity.
- **Product List by type:** Check all the products of given type.
- **Edit and Add:** You can edit and products.
- **Provider** Keep track of the providers of products.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Database - MySQL

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/01sainath/Product_Manager.git
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Configure the database:

    - Update `application.properties` with your database credentials.

4. Run the application:

   - Use STS(Spring tool suite) or Intellij IDEA for running this application.
   - Import the project into workspace as maven project.
   - Then update it.
   - Run it as spring boot app

6. Open [http://localhost:8080](http://localhost:8080) in your browser or postman

## Usage

- Access the application through the provided URL.
- Check the com.app.controller -> ProductController, ProviderController for urls.
- Start managing your products and inventory efficiently.
