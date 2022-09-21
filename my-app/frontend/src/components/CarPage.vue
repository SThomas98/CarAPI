<template>
   <v-app id="background">
      <v-btn elevation="2" width="100px" @click="getCar">Click</v-btn>
   </v-app>
</template>

<script>
import carApi from './js/CarApi.js'

export default {

   data() {
      return {
         cars: {
            model: null
         },

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