<template>
   <v-app id="background">
      <v-card class="mx-auto my-12" max-width="400" width="500">
         <div class="my-4">Click to see a car and the model of the car given.</div>
         <v-divider class="mx-5"></v-divider>

         <v-btn elevation="2" @click="getCar" class="my-4">Load Car</v-btn>

         <template slot="progress">

         </template>

         <v-img
         height="250"
         :src="this.cars.img"
         ></v-img>

         <v-card-title class="justify-center">{{this.cars.model}}</v-card-title>
      </v-card>
   </v-app>
</template>

<script>
import carApi from './js/CarApi.js'

export default {

   data() {
      return {
         cars: {
            model: '',
            img: ''
         }
      }
   },

   methods: {
      getCar() {
         carApi.getCars()
         .then(response=> {
            this.cars.model = response.data;
            console.log(response.data)
         });
      }
   }
}
</script>

<style>
   #background {
      background: #3A1C71;
      background: -webkit-linear-gradient(to right, #FFAF7B, #D76D77, #3A1C71);
      background: linear-gradient(to right, #FFAF7B, #D76D77, #6d2a99);
    }
</style>