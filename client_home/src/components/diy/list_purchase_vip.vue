<template>
	<view class="list_purchase_vip list_com--new" style="background-color: #fff;">
		<!-- 视图 -->
		<view class="purchase_vip_block box_wrap" >
			<navigator class="item_purchase_vip box_style" v-for="(o, i) in list"  :key="i" :url="'/pages/purchase_vip/details?purchase_vip_id=' + o['purchase_vip_id']">
					<view class="view" v-if="0 && $check_index_field('get','book_number','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>图书编号</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["book_number"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','book_name','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>图书名称</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["book_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','book_category','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>图书类别</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["book_category"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','author','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>作者</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["author"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','vip_price','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>VIP价格</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["vip_price"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','user_number','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>用户编号</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_user_number(o['user_number']) }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','full_name','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>姓名</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["full_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','telephone','/purchase_vip/list')">
					<view class="title" v-if="true">
						<span>电话</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["telephone"] }}</span>
					</view>
						</view>
					<view class="bottom-view">
				</view>
				<view class="view">
					<view class="create_time_block diy_field number">
						<span>{{ $toTime(o["create_time"],"yyyy-MM-dd hh:mm:ss") }}</span>
					</view>
				</view>
			</navigator>
		</view>
		<!-- /视图 -->
	</view>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				}
			}
		},
		data() {
			return {
										// 用户列表
				list_user_user_number: [],
						}
		},
		methods: {
			/**
			 *  跳转链接
			 *  @param {Object} id
			 */
			to_nav(id) {
				this.$nav('/pages/purchase_vip/details?purchase_vip_id=' + id)
			},
									/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_number() {
				var json = await this.$get("~/api/user/get_list?user_group=注册用户");
				if(json.result && json.result.list){
					this.list_user_user_number = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_user_number(id){
				let obj = this.list_user_user_number;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
					},
		created() {
									this.get_list_user_user_number();
					}
	}
</script>

<style scoped>
	.list_purchase_vip {
		/* padding: 0 1rem; */
		margin-bottom: 1rem;
	}

	.list_purchase_vip .list_purchase_vip_table {
		width: 100%;
		padding: 5px 0;
	}

	.list_purchase_vip .list_purchase_vip_table .btn_change_table {
		margin-left: auto;
		font-weight: bold;
		padding: 0.5rem 0;
		width: 100px;
		text-align: center;
		font-size: 0.875rem;
		border: 1px solid #CCCCCC;
		border-radius: 1rem;
		margin-bottom: 0.25rem;
	}

	.list_purchase_vip .list_purchase_vip_table .purchase_vip_table_block .uni-table-td{
		padding: 8px;
	}

	.list_purchase_vip .list_purchase_vip_table .purchase_vip_table_block .image {
		width: 10%;
	}

	.list_purchase_vip .list_purchase_vip_table .purchase_vip_table_block .text {
		overflow: hidden;
		width: 30%;
		font-size: 0.5rem;
	}

	.list_purchase_vip .list_purchase_vip_table .purchase_vip_table_block .hits {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_purchase_vip .list_purchase_vip_table .purchase_vip_table_block .praise {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_purchase_vip .list_purchase_vip_table .purchase_vip_table_block .create_time {
		width: 26%;
		font-size: 0.5rem;
	}
	.list_purchase_vip .item_purchase_vip {
		display: flex;
		justify-content: space-between;
		align-items: stretch;
		padding: 0.75rem 1rem;

	}
	.list_purchase_vip .item_purchase_vip+.item_purchase_vip{
		border-top: 1px solid #dbdbdb;
	}
	.list_purchase_vip .item_purchase_vip .left>image {
		position: relative;
		top: 50%;
		transform: translate(0, -50%);
		border-radius: 0.5rem;
	}

	.list_purchase_vip .item_purchase_vip .right_block {
		width: calc(100% - 5rem);
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.list_purchase_vip .top {
		font-size: 0.9rem;
	}


	.list_purchase_vip .time {
		font-size: 0.6rem;
		color: var(--color_grey)
	}

	.list_purchase_vip .bottom {
		display: flex;
		justify-content: space-between;
		align-items: baseline;
		font-size: 0.5rem;
		color: var(--color_grey)
	}

	.list_purchase_vip .see {
		margin-left: 1rem;
	}
	.box_wrap{
		padding: 0.75rem;
	}
	.box_style{
		margin-bottom: 0.75rem;
		padding: 0.375rem;
		display: inline-block !important;
		border: 0.075rem solid #ccc;
		border-radius: 0.375rem;
		overflow: hidden;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.bottom-view,.create_time_block{
		font-size: 12px;
		color: #666666;
	}
	.bottom-view view{
		display: inline-block;
	}
	.bottom-view span{
		margin-left: 5px;
		margin-right: 10px;
	}
/* new style start */
	.list_com--new .box_wrap{
		display: flex;
		flex-wrap: wrap;
		padding-left: 0 !important;
		padding-right: 0 !important;
		justify-content: space-between;
	}
	.list_com--new .box_style:nth-child(even) {
    	margin-left: 0 !important;
	}
    .list_com--new .box_wrap .box_style{
		display: inline-block !important;
		width: 48%;
		max-width: 48%;
		overflow: hidden;
		border-color: var(--color_primary);
		box-sizing: border-box;
		padding:8px!important;
    }
    .list_com--new .view{
        display: flex;
        overflow: hidden;
		width:100%;
    }

    .list_com--new .view .title span{
       white-space: nowrap;
    }
    .list_com--new .view .text{
        display: flex;
        color: var(--color_primary);
        margin-left: 10px;
        border-bottom: 1px solid #ccc;
        white-space: nowrap;
    }
     .list_com--new .view .text span{
        max-width: 100px;
        overflow: hidden;
        text-overflow: ellipsis;
    }

     .list_com--new .view .number{
        color: var(--color_primary);
    }

    .list_com--new .view .image{
        width: 100%;
        border-bottom: 1px solid #ccc;
		margin-top:5px;
    }

	.list_com--new .diy_field.text{
		overflow: hidden;
		margin-right: -8px;
	}

/* new style start */

</style>

