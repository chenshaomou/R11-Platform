/**
 * Created by 熊超超 on 2017/8/4.
 */
const Index = () => ({component: import(/* webpackChunkName: "pm" */ '@/module/pm/components/Index')})
const HomePage = () => ({component: import(/* webpackChunkName: "pm" */ '@/module/pm/components/HomePage')})

export default [{
  path: '/',
  alias: '/pm',
  component: Index,
  children: [
    {
      path: '',
      name: 'homePage',
      component: HomePage
    }
  ]
}
]
