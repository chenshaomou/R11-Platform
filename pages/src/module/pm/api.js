/**
 * Created by 熊超超 on 2017/8/5.
 */
import conn from '../../global/conn'

export default {
  addNewApp: data => {
    return conn.post('/protection/pm/new', {params: data})
    // .then(res => ({res})).catch(err => ({err}))
  }
}
