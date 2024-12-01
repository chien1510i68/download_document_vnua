// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyBcqWfH1q-lpTesmjdgu6lJS41L0R-IwtU",
  authDomain: "document-vnua.firebaseapp.com",
  projectId: "document-vnua",
  storageBucket: "document-vnua.firebasestorage.app",
  messagingSenderId: "518868542682",
  appId: "1:518868542682:web:6e08c073740fa3e659f1e3",
  measurementId: "G-9EQWGNJWV2"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);