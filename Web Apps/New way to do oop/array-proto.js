var arr = ['1','2','3'];

var newArr = arr.map((index,element) => {
    return index + '-->' + element;
});


console.log(arr);
console.log(newArr.keys());
