'strict'

//alert("I'm connected");

document.getElementById("getButton").addEventListener('click', getThingById);

const myAddress = "http://localhost:8080/Thing"

function testFunction(){
alert("event listener working");
}

function getThingById(){
  let myFullAddress = myAddress + "/getById/" + document.getElementById("getId").value;
   axios.get(myFullAddress).then(res => showThing(res)).catch(err => alert("not working yet"));


}

function showThing(res){
    document.getElementById("singleThing").innerText = `name = ${res.data.name}, description =  ${res.data.description}, priority = ${res.data.priority}`;
}

