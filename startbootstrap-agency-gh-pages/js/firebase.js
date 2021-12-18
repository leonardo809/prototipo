
      // Import the functions you need from the SDKs you need
      import { initializeApp } from "https://www.gstatic.com/firebasejs/9.1.0/firebase-app.js";
      import { getFirestore, doc,setDoc,getDoc } from "https://www.gstatic.com/firebasejs/9.1.0/firebase-firestore.js";
      import { getStorage,ref,uploadBytes } from "https://www.gstatic.com/firebasejs/9.1.0/firebase-storage.js";
      // TODO: Add SDKs for Firebase products that you want to use
      // https://firebase.google.com/docs/web/setup#available-libraries
      
      const upload=async({file})=>{
        const storage=getStorage()
        var storageRef=ref(storage,`images/${file.name}`);
      
         uploadBytes(storageRef, file).then((snapshot) => {

});
        return storageRef;
      }

      

      const publish = async ({file},nombre,pap,sap,curp,fecha,altura,peso)=>{
        const db = getFirestore();
        const ref = doc(db, "castings",curp);
        let storageRef = await upload({file});
        const docRef = doc(db, "castings", curp.toUpperCase());
        const docSnap = await getDoc(docRef);

        if (docSnap.exists()) {
                return alert("Ya se ha registrado previamente");
        } else {
             // doc.data() will be undefined in this case
             return setDoc(ref, {
                nombre: nombre,
                pApellido: pap,
                sApellido: sap,
                curp: curp,
                fecha: fecha,
                altura: altura,
                peso: peso,
                imagen: storageRef.fullPath
              })
                .then(() => {
                  alert("Su registro se ha guardado");
                  
                })
                .catch((error) => alert("Falló su registro" + error));
        }
      
      }

      const vacio = (nombre,curp,fecha,altura,peso,file)=>{
    if(nombre===""||curp===""||fecha===""||altura===""||peso===""||file==="") return true;
    return false;
      }

      const nulos=(nombre,curp,fecha,altura,peso,file)=>{
          if(nombre===null||curp===null||fecha===null||altura===null||peso===null||file===null) return true;
      return false;
      }
      const indef=(nombre,curp,fecha,altura,peso,file)=>{
          if(nombre===undefined||curp===undefined||fecha===undefined||altura===undefined||peso===undefined||file===undefined) return true;
      return false;
      }

      // Your web app's Firebase configuration
      async function main(){
        const firebaseConfig = {
        apiKey: "AIzaSyAGp_2frK6b4PXnoZ05WfBMwySU9QdCEb8",
        authDomain: "castings-filtros.firebaseapp.com",
        databaseURL: "https://castings-filtros-default-rtdb.firebaseio.com",
        projectId: "castings-filtros",
        storageBucket: "castings-filtros.appspot.com",
        messagingSenderId: "351752169306",
        appId: "1:351752169306:web:2af10a0634412ab25b3563",
      };

      // Initialize Firebase
      const app = initializeApp(firebaseConfig);
      

      
      
      let form=document.querySelector("#uploader");
      

      form.addEventListener("submit", (event) => {
        event.preventDefault();

        let fileInput = form.querySelector("#imagen");
        let nombre = document.getElementById("IDnombre").value;
        let primerA = document.getElementById("app").value;
        let segundoA = document.getElementById("apm").value;
        let curp = document.getElementById("IDcurp").value;
        let fecha = document.getElementById("IDedad").value;
        let altura = document.getElementById("IDaltura").value;
        let peso = document.getElementById("IDpeso").value;
        let file = fileInput.files[0];
        if(vacio(nombre,curp,fecha,altura,peso,file)){
            alert("Llene todos los campos requeridos");
        }
        else{
            if(nulos(nombre,curp,fecha,altura,peso,file)){
                alert("Tiene campos nulos");
            }
            else{
                if(indef(nombre,curp,fecha,altura,peso,file)){
                    alert("Tiene campos indefinidos");
                }else{
                    if(altura>272&&altura<72.1){
                        alert("Su altura está fuera de rango");
                    }else{
                        if(peso>600&&peso<22){
                            alert("Su peso está fuera de rango");
                        }
                        else{
                            
                           
                            publish({file: file},nombre,primerA,segundoA,curp.toUpperCase(),fecha,altura,peso);
          
                 
                           
                        }   
                    }
                }
            }

        }
        
        
      });
      
    }
    main();