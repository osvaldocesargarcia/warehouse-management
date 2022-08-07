# warehouse-management (case study)

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#problem-description">Problem Description</a></li>
        <li><a href="#application-requirements">Application requirements</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
   
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
The present project is a case study to test my skills as a fullstack developer. It is a web application programmed with modern technologies: Angular and Spring Boot. Nowadays these frameworks are very popular in web programmation branch and the combination of both is very common. In the following section I provide details of the problem.

### Problem Description
MEDMOR SA, a company specialized in the sale and distribution of hardware products, wants to control and optimize its inventory processes. To do so, it needs to implement an API that allows it to manage all areas and products in the warehouse. The warehouse has sections. Each section has a size in square meters, the type of product destined to it, which can be Electrical Materials, Equipment, Locksmith, Tools and Plumbing. Each product has a size, color, price, if it is fragile, type of packaging (Cardboard, Plastic, Glass, Nylon) and lot. To operate the system, two main roles are defined: Administrator and Operator. The Administrator has access to the entire system, while the Operator will be restricted to delete sections.

### Application requirements
#### Spring Boot API
Implement an API in Spring Boot that allows to fulfill the following requirements: 
##### 1.1- Add a given quantity of a product to a section.
##### 1.2- Create/edit/delete a new section in a warehouse. Only sections that do not contain products can be deleted. 
##### 1.3- List product information, and perform filtering operation by: section, lot, fragility, color, price range, 
##### and type of packaging. 






