
# CursedBirb CS defense Thesis

No idea about how to write it properly so here is a simple explonation

My defense thesis on automation and orchestration using github actions, docker and kubernetes

# How to run

Docker

Requirements: 1 terminal, docker and entire project

Go to the project main folder

```bash
docker compose up
```


Kubernetes

Requirements: 2 terminals, docker, minikube and .kubernetes folder files

Images will download itself so you dont need more

Open first terminal and move to the forlder with kubernetes files

```bash
minikube start

#This will start our k8 virtual machine

kubect apply -f database-deployment.yaml

kubect apply -f backend-deployment.yaml

kubect apply -f frontend-deployment.yaml

#Those three will start our app

minikube tunnel

#This is to make us get a external ip for our backend

Open now a second terminal

minikube service frontend-react

#This will allow you to open app in the browser and use it

```
