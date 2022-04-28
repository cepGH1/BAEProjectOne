'strict'

//alert("I'm connected");

document.getElementById("getButton").addEventListener('click', getThingById);
document.getElementById("removeButton").addEventListener('click', removeThing );
window.addEventListener('load', getAllThing);
document.getElementById("createButton").addEventListener('click', create);
document.getElementById("fetchButton").addEventListener('click', fetchThing );
document.getElementById("editedButton").addEventListener('click', replace);

const myAddress = "http://localhost:8080/Thing"

function testFunction(){
alert("event listener working");
}

function getThingById(){
  let myFullAddress = myAddress + "/getById/" + document.getElementById("getId").value;
   axios.get(myFullAddress).then(res => showThing(res)).catch(err => alert("Couldn't find that item number"));


}

function showThing(res){
    document.getElementById("singleThing").innerText = `name = ${res.data.name} \n description =  ${res.data.description} \n priority = ${res.data.priority}`;
}

function fetchThing(){
    let myFullAddress = myAddress + "/getById/" + document.getElementById("editedId").value;
   axios.get(myFullAddress).then(edRes => showEditThing(edRes)).catch(err => alert("not working yet"));
}

function showEditThing(edRes){
    document.getElementById("editedName").value = edRes.data.name;
    document.getElementById("editedDescription").value = edRes.data.description;
    document.getElementById("editedPriority").value = edRes.data.priority;
}

function getAllThing(){
    axios.get(myAddress + "/getAll").then(resAll => showAllThing(resAll)).catch(err => alert("request failed"));
}
function showAllThing(resAll){
    // document.getElementById("fullList").innerText = JSON.stringify(resAll.data);
     let contents = document.getElementById("fullList");
    let listDisplay = "<div>";
    for(let i = 0; i<resAll.data.length; i++){
        listDisplay += resAll.data[i].id + ";  " + resAll.data[i].name + " ;  " +  resAll.data[i].description + " ; PRIORITY " + resAll.data[i].priority + "<br>";
    }
    listDisplay += "</div>"
   
    //document.getElementById("fullList").append( listDisplay);
   
   document.getElementById("fullList").innerHTML = listDisplay;

}

function removeThing(){
    let myFullAddress = myAddress + "/delete/" + document.getElementById("getIdForRemoval").value;
    axios.delete(myFullAddress).then(resdel => showDeletedMessage(resdel)).catch(err => alert("not possible"))
    
}
function showDeletedMessage(resdel){
    alert(document.getElementById("getIdForRemoval").value + " has been deleted");
    getAllThing();
}

function replace(){
    let myBody = {id:parseInt(document.getElementById("editedId").value), name:document.getElementById("editedName").value, description:document.getElementById("editedDescription").value, priority:document.getElementById("editedPriority").value};
    let myFullAddress = myAddress + "/update/" + document.getElementById("editedId").value;
    axios.put(myFullAddress, myBody).then(resput => showReplace(resput)).catch(err => alert("not working yet"));
}

function showReplace(resput){
   // alert("worked");
    document.getElementById("fullList");
    getAllThing();

}


function create(){
    if(!document.getElementById("createdName").value == null || !document.getElementById("createdName").value == " " ){
        let myBody = {name:document.getElementById("createdName").value, description:document.getElementById("createdDescription").value, priority: document.getElementById("createdPriority").value};
        let myFullAddress = myAddress + "/create";

        axios.post(myFullAddress, myBody).then(rescr => showCreate(rescr)).catch(err => alert("not working yet"));}else{
        alert("please enter a name for this item");
    }

}

function showCreate(rescr){
   // alert("worked");
    getAllThing();
    clearTheCreateFields();
}

function clearTheCreateFields(){
    document.getElementById("createdName").value = "";
    document.getElementById("createdPriority").value = "";
    document.getElementById("createdDescription").value ="";
}