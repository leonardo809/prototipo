/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author leonardo
 */
public class firebase {
static Firestore db;

    public static void conectar() throws FileNotFoundException, IOException{
FileInputStream serviceAccount =
  new FileInputStream("castings.json");

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl("https://castings-filtros-default-rtdb.firebaseio.com")
  .build();

FirebaseApp.initializeApp(options);
db=FirestoreClient.getFirestore();

}
public static void leer() throws InterruptedException, ExecutionException{
// asynchronously retrieve the document
Globales glo= new Globales();
ApiFuture<QuerySnapshot> future = db.collection("castings").get();

// ...
// future.get() blocks on response
List<QueryDocumentSnapshot> documents = future.get().getDocuments();
for (QueryDocumentSnapshot document : documents) {
    glo.casting.add(document.toObject(Casting.class));
}
}
 public static String getLink(String blobName)
      throws StorageException, FileNotFoundException, IOException {

String SERVICE_ACCOUNT_JSON_PATH = "castings.json";

Storage storage =
    StorageOptions.newBuilder()
        .setCredentials(
            ServiceAccountCredentials.fromStream(
                new FileInputStream(SERVICE_ACCOUNT_JSON_PATH)))
        .build()
        .getService();
 
URL signedUrl=storage.signUrl(BlobInfo.newBuilder("castings-filtros.appspot.com",blobName).build(),14, TimeUnit.DAYS);
    return signedUrl.toString();
   
  }

}
