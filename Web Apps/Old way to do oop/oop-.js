function Animal(name) {
  this.name = name;
}
Animal.prototype.speak = function () {
  console.log('Animal::speak:', this.name);
};

var a = new Animal('animal-1');
//a.speak();

function Dog(name) {
  Animal.call(this, name);
}

Dog.prototype = Object.create(Animal.prototype);
Dog.prototype.speak = function () {
  console.log('Dog::speak:', this.name);
}

var d = new Dog("Snoop dog");
console.log(Object.keys(Object.getPrototypeOf(d)));
d.speak();


function Bird(name) {
  Animal.call(this, name);
}

Bird.prototype = Object.create(Bird.prototype);
Bird.prototype.speak = function () {
  console.log("Bird::churulik:", this.name);
}
var bird = new Bird("Радка");
bird.speak();
