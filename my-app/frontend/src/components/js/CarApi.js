import axios from 'axios'

const AXIOS = axios.create({
    baseURL: `/home`
  });

export default {

	// Get featured items for home slider.
    getCars() {
        return AXIOS.get('/cars')
    },
}
