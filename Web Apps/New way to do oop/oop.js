class Animal {
    constructor(name) {
        this.name = name;
    }
    speak() {
        console.log('Animal::speaks:', this.name);
    }
}
class Dog extends Animal {
    constructor(name) {
        super(name);
    }
    speak() {
        console.log('Dog::speaks:', this.name)
    }
}

var a = new Animal("Qsen");
a.speak();
var dog = new Dog("Radka");
dog.speak();