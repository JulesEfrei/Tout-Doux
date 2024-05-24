<div id="top"></div>

<!-- [![Contributors][contributors-shield]][contributors-url] -->
<!-- [![Stargazers][stars-shield]][stars-url] -->
[![Forks][forks-shield]][forks-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]


<!-- PROJECT LOGO -->
<br />
<div align="center">

<h2 align="center">Tout Doux</h2>

  <p align="center">
    Simple Kanban application with authentication using Java Spring Boot and MySQL.
    <br />
    <!-- <a href="https://github.com/JulesEfrei/Tout-Doux"><strong>Explore the docs</strong></a> -->
    <br />
    <br />
    <!-- <a href="https://github.com/JulesEfrei/Tout-Doux">View Demo</a>
    · -->
    <a href="https://github.com/JulesEfrei/Tout-Doux/issues">Report Bug</a>
    ·
    <a href="https://github.com/JulesEfrei/Tout-Doux/pulls">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap / Features</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#credit">Credit</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Simple Kanban list application with authentication system.<br/>
This project is a school project linked to the Spring Boot module of 2 days. *The project will no longer be maintained.*

* State of the Project --> **Beta**
* Main difficulties - [Roadmap](#roadmap)


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

This section should list any major frameworks/libraries used to bootstrap your project.

* [Spring Boot](https://spring.io/)
* [MySQL](https://www.mysql.com/fr/)
* [Docker](https://www.docker.com/)
* [Bootstrap](https://getbootstrap.com/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.


### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/JulesEfrei/Tout-Doux.git
   ```
2. Start the application with docker (the docker configuration is for development only -> Not recommended in production)
   ```sh
   docker compose up -d
   ```
3. Wait a minute for the project to install correctly
4. When the app is ready, navigate to [localhost:8080](http://localhost:8080)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

Here is the roadmap of the project. Checked flags mean the features is out and unchecked flags mean that the feature is comming.

- [x] Initialize the project
- [x] Create entities
  - [x] User
  - [x] Task
  - [x] Board
  - [x] State
  - [ ] Category
- [x] CRUD on Task
  - [x] Create task
  - [x] Read all tasks of a user
  - [x] Read all tasks of a board
  - [x] Modify task
  - [x] Delete task
- [x] CRUD on Board
  - [x] Create board
  - [x] Read all boards of a user
  - [x] Modify board
  - [x] Delete board
- [x] CRUD on State
    - [x] Create state
    - [x] Read all states of a board
    - [x] Modify state
    - [x] Delete state
- [x] Create an account
- [x] Log in
- [x] Basic UI
- [x] Can't modify, read or delete task of another user
- [x] Docker ready
- [x] Error handling
- [x] Secure the application

See the [open issues](https://github.com/JulesEfrei/Tout-Doux/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- Credit -->
## Credit

List of people

* [Jules Bruzeau](https://github.com/JulesEfrei)
* [Romain Monmarche](https://github.com/RoromainM)
* Younes Esslimani
* Salah Ouni

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Linked'in - [Jules](https://www.linkedin.com/in/jules-bruzeau/)

GitHub Profile: [JulesEfrei](https://github.com/JulesEfrei/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License.

<p align="right">(<a href="#top">back to top</a>)</p>






<!-- MARKDOWN LINKS & IMAGES -->
<!-- [contributors-shield]: https://img.shields.io/github/contributors/JulesEfrei/Tout-Doux.svg?style=for-the-badge
[contributors-url]: https://github.com/JulesEfrei/Tout-Doux/graphs/contributors -->
<!-- [stars-shield]: https://img.shields.io/github/stars/JulesEfrei/Tout-Doux.svg?style=for-the-badge
[stars-url]: https://github.com/JulesEfrei/Tout-Doux/stargazers -->
[forks-shield]: https://img.shields.io/github/forks/JulesEfrei/Tout-Doux.svg?style=for-the-badge
[forks-url]: https://github.com/JulesEfrei/Tout-Doux/network/members
[issues-shield]: https://img.shields.io/github/issues/JulesEfrei/Tout-Doux.svg?style=for-the-badge
[issues-url]: https://github.com/JulesEfrei/Tout-Doux/issues
[license-shield]: https://img.shields.io/github/license/JulesEfrei/Tout-Doux.svg?style=for-the-badge
[license-url]: https://github.com/JulesEfrei/Tout-Doux/blob/master/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/jules-bruzeau/
[product-screenshot]: images/screenshot.png
