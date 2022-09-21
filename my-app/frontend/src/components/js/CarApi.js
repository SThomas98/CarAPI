import axios from 'axios'

const AXIOS = axios.create({
    baseURL: `/home`
  });

export default {

	// Get car model.
    getCars() {
        return AXIOS.get('/car')
    },
}
