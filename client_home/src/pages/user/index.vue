<template>
	<view class="page_user page_user--new" id="user_index">
		<!-- 用户栏模块(开始) -->
		<view>
			<view class="container">
				<view>
					<view>
						<view class="">
							<view class="top_user" :style="'background:url('+bgc_avatar+') no-repeat;background-size:100% 100%;'">
								<image class="avatar" style="width: 6rem;height: 6rem;" :src="$fullUrl(user.avatar) || '@/static/img/default.png'" mode="scaleToFill"></image>
								<view class="name">
									<text style="font-size: 2rem;">{{user.nickname}}</text>
									<text style="font-size: 1.5rem;color: var(--color_grey);">{{user.user_group}}</text>
								</view>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 用户栏模块(结束) -->
		<!-- 菜单栏模块(开始) -->
		<view>
			<view class="container">
				<view>
					<view>
						<view class="">
							<view class="list_my">
								<view class="item_my" v-if="$check_action(o.url,'get')" v-for="(o,i) in list_info" :key="i">
									<navigator :url="'/pages'+o.url"  class="my_nav" hover-class="hover">
										<uni-icons :type="o.type" size="20"></uni-icons>
										<text class="name">{{ o.title }}</text>
									</navigator>
								</view>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 菜单栏模块(结束) -->

		<!-- 自定义栏模块(开始) -->
		<view>
			<view class="container">
				<view>
					<view>
						<view class="">
							<view  class="list_module">
									<view v-if="user_group != '管理员' && $check_action('/registered_users/table','get')">
									<navigator class="my_module" url="/pages/registered_users/table" hover-class="hover">
										<div>
											<text>注册用户</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/novel_classification/table','get')">
									<navigator class="my_module" url="/pages/novel_classification/table" hover-class="hover">
										<div>
											<text>小说分类</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/online_books/table','get')">
									<navigator class="my_module" url="/pages/online_books/table" hover-class="hover">
										<div>
											<text>线上图书</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/personal_bookshelf/table','get')">
									<navigator class="my_module" url="/pages/personal_bookshelf/table" hover-class="hover">
										<div>
											<text>个人书架</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/online_reading/table','get')">
									<navigator class="my_module" url="/pages/online_reading/table" hover-class="hover">
										<div>
											<text>在线阅读</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/read_settings/table','get')">
									<navigator class="my_module" url="/pages/read_settings/table" hover-class="hover">
										<div>
											<text>阅读设置</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/font_style/table','get')">
									<navigator class="my_module" url="/pages/font_style/table" hover-class="hover">
										<div>
											<text>字体样式</text>
											<span>></span>
										</div>
									</navigator>
								</view>
										<view v-if="user_group != '管理员' && $check_action('/purchase_vip/table','get')">
									<navigator class="my_module" url="/pages/purchase_vip/table" hover-class="hover">
										<div>
											<text>购买VIP</text>
											<span>></span>
										</div>
									</navigator>
								</view>
								</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 自定义栏模块(结束) -->

		<!-- 按钮模块(开始) -->
		<view>
			<view class="container">
				<view>
					<view>
						<view class="">
							<view class="btns">
								<view  class="btn btn_logout" v-if="user.user_id" @click="sign_out()">
									退出登录
								</view>
								<navigator v-else class="btn btn_login" url="/pages/account/login" type="default" >登录</navigator>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 按钮模块(结束) -->
	</view>
</template>

<script>
	import nav_quick from "@/components/diy/nav_quick.vue";

	import mixin from "@/libs/mixins/page.js";
	export default {
		components: {
			nav_quick
		},
		mixins: [mixin],
		data() {
			return {
				list_info: [{
						title: "基本信息",
						type: "info",
						url: "/user/info"
					},
					{
						title: "收藏",
						type: "heart",
						url: "/user/collect"
					},
				],
				bgc_avatar: "@/static/img/bgc_1.jpg"
			}
		},
		methods: {
			sign_out() {
				this.$store.commit('sign_out');
				// this.$get("~/api/user/sign_out")
			}
		}
	}
</script>

<style scoped>
	.page_user {
		background-color: #F7F7F7;
	}

	.top_user {
		background-color: #fff;
		display: flex;
		flex-direction: column;
		justify-content: flex-start;
		align-items: center;
		padding: 1rem;
		margin-bottom: 1rem;
	}

	.top_user .avatar {
		border-radius: 1rem;
		box-shadow: 0px 0px 4px 2px #eee;
	}

	.top_user .name {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}

	.btns {
		padding: 1rem;
	}

	.list_my {
		display: flex;
		justify-content: flex-start;
		flex-wrap: wrap;
		text-align: center;
		background-color: #fff;
		padding: 0.5rem 0.2rem 0;
	}

	.item_my {
		flex: 1;
		padding-bottom: 0.5rem;
	}

	.my_nav {
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.my_nav text {
		font-size: 0.5rem;
	}
	.btn{
		text-align: center;
	}
	.btn_logout{
		background-color: var(--color_primary);
		color: #fff;
	}

	.my_module {
		font-size: 0.5rem;
		line-height: 2.5rem;
	}

	.my_module div{
		width: 80%;
		margin: 0 auto;
		border-bottom: 1px solid #666;
	}

	.my_module span{
		float: right;
		padding-right: 0.5rem;
		color: #666;
	}

	.list_module {
		justify-content: flex-start;
		background-color: #fff;
		padding: 0.5rem 0.2rem 1.5rem;
	}

	/*new style start*/
	.page_user--new .btn_logout,.page_user--new .btn_login{
		border-radius: 10px;
    	height: 46px;
		display: flex;
		align-items: center;
		justify-content: center;
		font-size: 16px;
		background: var(--color_primary);
		color: var(--color_white);
	}
	.list_module {
		padding-top: 0;
		padding-bottom: 0;
	}
	.list_module uni-view:first-child{
		padding-top: 0.5rem;
	}
	.list_module uni-view:last-child{
		padding-bottom: 1.5rem;
	}
	/*new style end*/

</style>
