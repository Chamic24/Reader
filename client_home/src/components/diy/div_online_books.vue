<template>
	<view class="diy_details diy_div_online_books">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','book_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>图书编号:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["book_number"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','book_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>图书名称:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["book_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','book_category')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>图书类别:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["book_category"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','cover')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>封面:</span>
						</view>
							<view class="diy_field diy_img">
							<image style="width:100%;height:auto;" :src="$fullUrl(obj['cover'])" mode="widthFix"></image>
						</view>
						</view>
					<view v-if="$check_field('get','author')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>作者:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["author"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','press')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>出版社:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["press"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','vip_price')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>VIP价格:</span>
						</view>
							<view class="diy_field diy_number">
							<text>
								{{ obj["vip_price"] }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','book_introduction')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>图书简介:</span>
						</view>
							<view class="diy_field diy_desc">
							<text>
								{{ obj["book_introduction"] }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','details')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>详情:</span>
						</view>
							<view class="diy_field diy_desc">
							<text>
								{{ obj["details"] }}
							</text>
						</view>
						</view>
				</view>
			</view>
		</view>

			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/personal_bookshelf/edit')" v-if="$check_action('/personal_bookshelf/edit','add') || $check_action('/personal_bookshelf/edit','set')" >加入书架</button>
					</view>
				</view>
			</view>
		</view>
			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/purchase_vip/edit')" v-if="$check_action('/purchase_vip/edit','add') || $check_action('/purchase_vip/edit','set')" >购买VIP</button>
					</view>
				</view>
			</view>
		</view>
		</view>
</template>

<script>
	import mixin from "@/libs/mixins/component.js";
	export default {
		mixins: [mixin],
		props: {
			obj_goods: {
				type: Object,
				default(){
					return {}
				}
			},
			query:{
				type: Object,
				default(){
					return {
						online_books_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
												}
		},
		methods: {
			async get_obj_goods_type() {
				var res = await this.$get("~/api/goods_type/get_obj", {
					name: this.obj_goods.type
				})

				if (res.result.obj) {
					this.obj_goods_type = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
			async get_obj_by_goods() {
				var {
					source_table,
					source_field
				} = this.obj_goods_type
				var {
					source_id
				} = this.obj_goods
				var query = {}
				query[source_field] = source_id
				this.$get("~/api/" + source_table + "/get_obj", {}, (res) => {
					if (res.result.obj) {
						this.obj = res.result.obj
					} else {
						console.log("没有请求到商品分类");
					}
				})
			},
			async get_obj_by_id(){
				var res = await this.$get("~/api/online_books/get_obj", {
					online_books_id:this.query.online_books_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
											},
		created() {
											},
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["online_books_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_online_books_details {}

	.details {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
		border-bottom: 1px solid #eee;
	}

	.left_text {
		flex: 0 0 25%;
	}

	.right_text {
		flex: 0 0 75%;
	}
	.edit_nav{
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}
</style>
