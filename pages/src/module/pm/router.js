/**
 * Created by 熊超超 on 2017/8/4.
 */
const Index = () => ({component: import(/* webpackChunkName: "pm" */ '@/module/pm/components/Index')})
const AppListPage = () => ({component: import(/* webpackChunkName: "pm" */ '@/module/pm/components/AppListPage')})
const NewAppPage = () => ({component: import(/* webpackChunkName: "pm" */ '@/module/pm/components/NewAppPage')})

export default [{
  path: '/',
  alias: '/pm',
  component: Index,
  children: [
    {
      path: '',
      name: 'appListPage',
      component: AppListPage
    },
    {
      path: '/newAppPage',
      name: 'newAppPage',
      component: NewAppPage
    }
  ]
}
]
