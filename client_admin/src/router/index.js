import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },


	// 论坛路由
	{
		path: '/forum/table',
		name: 'forum_table',
		component: () => import('../views/forum/table.vue'),
		meta: {
			index: 0,
			title: '论坛列表'
		}
	},
	{
		path: '/forum/view',
		name: 'forum_view',
		component: () => import('../views/forum/view.vue'),
		meta: {
			index: 0,
			title: '论坛详情'
		}
	},

	// 论坛分类路由
	{
		path: '/forum_type/table',
		name: 'forum_type_table',
		component: () => import('../views/forum_type/table.vue'),
		meta: {
			index: 0,
			title: '论坛分类列表'
		}
	},
	{
		path: '/forum_type/view',
		name: 'forum_type_view',
		component: () => import('../views/forum_type/view.vue'),
		meta: {
			index: 0,
			title: '论坛分类详情'
		}
	},

	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 注册用户路由
	{
		path: '/registered_users/table',
		name: 'registered_users_table',
		component: () => import('../views/registered_users/table.vue'),
		meta: {
			index: 0,
			title: '注册用户列表'
		}
	},
	{
		path: '/registered_users/view',
		name: 'registered_users_view',
		component: () => import('../views/registered_users/view.vue'),
		meta: {
			index: 0,
			title: '注册用户详情'
		}
	},
	// 小说分类路由
	{
		path: '/novel_classification/table',
		name: 'novel_classification_table',
		component: () => import('../views/novel_classification/table.vue'),
		meta: {
			index: 0,
			title: '小说分类列表'
		}
	},
	{
		path: '/novel_classification/view',
		name: 'novel_classification_view',
		component: () => import('../views/novel_classification/view.vue'),
		meta: {
			index: 0,
			title: '小说分类详情'
		}
	},
	// 线上图书路由
	{
		path: '/online_books/table',
		name: 'online_books_table',
		component: () => import('../views/online_books/table.vue'),
		meta: {
			index: 0,
			title: '线上图书列表'
		}
	},
	{
		path: '/online_books/view',
		name: 'online_books_view',
		component: () => import('../views/online_books/view.vue'),
		meta: {
			index: 0,
			title: '线上图书详情'
		}
	},
	// 个人书架路由
	{
		path: '/personal_bookshelf/table',
		name: 'personal_bookshelf_table',
		component: () => import('../views/personal_bookshelf/table.vue'),
		meta: {
			index: 0,
			title: '个人书架列表'
		}
	},
	{
		path: '/personal_bookshelf/view',
		name: 'personal_bookshelf_view',
		component: () => import('../views/personal_bookshelf/view.vue'),
		meta: {
			index: 0,
			title: '个人书架详情'
		}
	},
	// 在线阅读路由
	{
		path: '/online_reading/table',
		name: 'online_reading_table',
		component: () => import('../views/online_reading/table.vue'),
		meta: {
			index: 0,
			title: '在线阅读列表'
		}
	},
	{
		path: '/online_reading/view',
		name: 'online_reading_view',
		component: () => import('../views/online_reading/view.vue'),
		meta: {
			index: 0,
			title: '在线阅读详情'
		}
	},
	// 阅读设置路由
	{
		path: '/read_settings/table',
		name: 'read_settings_table',
		component: () => import('../views/read_settings/table.vue'),
		meta: {
			index: 0,
			title: '阅读设置列表'
		}
	},
	{
		path: '/read_settings/view',
		name: 'read_settings_view',
		component: () => import('../views/read_settings/view.vue'),
		meta: {
			index: 0,
			title: '阅读设置详情'
		}
	},
	// 字体样式路由
	{
		path: '/font_style/table',
		name: 'font_style_table',
		component: () => import('../views/font_style/table.vue'),
		meta: {
			index: 0,
			title: '字体样式列表'
		}
	},
	{
		path: '/font_style/view',
		name: 'font_style_view',
		component: () => import('../views/font_style/view.vue'),
		meta: {
			index: 0,
			title: '字体样式详情'
		}
	},
	// 购买VIP路由
	{
		path: '/purchase_vip/table',
		name: 'purchase_vip_table',
		component: () => import('../views/purchase_vip/table.vue'),
		meta: {
			index: 0,
			title: '购买VIP列表'
		}
	},
	{
		path: '/purchase_vip/view',
		name: 'purchase_vip_view',
		component: () => import('../views/purchase_vip/view.vue'),
		meta: {
			index: 0,
			title: '购买VIP详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "小说阅读器-admin";
	document.title = title;
})

export default router
