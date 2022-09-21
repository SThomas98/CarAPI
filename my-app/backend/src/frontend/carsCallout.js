import axios from 'axios'

const AXIOS = axios.create({
   baseURL: `/`
});

export default {

	// Get the order details.
   getCars() {
      return AXIOS.get('/cars')
   }
}