<template>
	<view class="diy_edit page_purchase_vip" id="purchase_vip_edit">
		<view class='warp'>
			<view class='container'>
				<view class='row'>
						<view v-if="$check_field('set','book_number') || $check_field('add','book_number') || $check_field('get','book_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								图书编号:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_book_number" v-model="form['book_number']" placeholder="请输入图书编号" v-if="(form['book_number'] && $check_field('set','book_number')) || (!form['book_number'] && $check_field('add','book_number'))" :disabled="disabledObj['book_number_isDisabled']" />
							<text v-else-if="$check_field('get','book_number')">{{ form['book_number'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','book_name') || $check_field('add','book_name') || $check_field('get','book_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								图书名称:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_book_name" v-model="form['book_name']" placeholder="请输入图书名称" v-if="(form['book_name'] && $check_field('set','book_name')) || (!form['book_name'] && $check_field('add','book_name'))" :disabled="disabledObj['book_name_isDisabled']" />
							<text v-else-if="$check_field('get','book_name')">{{ form['book_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','book_category') || $check_field('add','book_category') || $check_field('get','book_category')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								图书类别:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_book_category" v-model="form['book_category']" placeholder="请输入图书类别" v-if="(form['book_category'] && $check_field('set','book_category')) || (!form['book_category'] && $check_field('add','book_category'))" :disabled="disabledObj['book_category_isDisabled']" />
							<text v-else-if="$check_field('get','book_category')">{{ form['book_category'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','author') || $check_field('add','author') || $check_field('get','author')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								作者:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_author" v-model="form['author']" placeholder="请输入作者" v-if="(form['author'] && $check_field('set','author')) || (!form['author'] && $check_field('add','author'))" :disabled="disabledObj['author_isDisabled']" />
							<text v-else-if="$check_field('get','author')">{{ form['author'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','vip_price') || $check_field('add','vip_price') || $check_field('get','vip_price')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								VIP价格:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_vip_price" v-model="form['vip_price']" placeholder="请输入VIP价格" v-if="(form['vip_price'] && $check_field('set','vip_price')) || (!form['vip_price'] && $check_field('add','vip_price'))" :disabled="disabledObj['vip_price_isDisabled']" />
							<text v-else-if="$check_field('get','vip_price')">{{ form['vip_price'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','user_number') || $check_field('add','user_number') || $check_field('get','user_number')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户编号:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_user_number"
									v-model="form['user_number']"
									:localdata="list_user_user_number"
									:clear="!disabledObj['user_number_isDisabled']"
									:disabled="disabledObj['user_number_isDisabled']"
									v-if="(form['user_number'] && $check_field('set','user_number')) || (!form['user_number'] && $check_field('add','user_number'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','user_number')">{{ form['user_number'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','full_name') || $check_field('add','full_name') || $check_field('get','full_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								姓名:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_full_name" v-model="form['full_name']" placeholder="请输入姓名" v-if="(form['full_name'] && $check_field('set','full_name')) || (!form['full_name'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']" />
							<text v-else-if="$check_field('get','full_name')">{{ form['full_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','telephone') || $check_field('add','telephone') || $check_field('get','telephone')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								电话:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_telephone" v-model="form['telephone']" placeholder="请输入电话" v-if="(form['telephone'] && $check_field('set','telephone')) || (!form['telephone'] && $check_field('add','telephone'))" :disabled="disabledObj['telephone_isDisabled']" />
							<text v-else-if="$check_field('get','telephone')">{{ form['telephone'] }}</text>
						</view>
										</view>
						<view v-if="user_group === '管理员' || $check_examine()" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								审核状态:
							</text>
						</view>
						<view class="diy_field diy_text diy_text_row diy_select_flex">
							<uni-data-select
									v-model="form['examine_state']"
									:localdata="list_examine_state"
							></uni-data-select>
						</view>
						<view class="diy_field diy_text diy_text_row">
							<text>
								{{ form['examine_state'] }}
							</text>
						</view>
					</view>
					<view v-if="user_group === '管理员' || $check_examine()" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								审核回复:
							</text>
						</view>
						<view class="diy_field diy_text diy_text_row">
							<textarea v-model="form['examine_reply']">
							</textarea>
						</view>
						<view class="diy_field diy_text diy_text_row">
							<text>
								{{ form['examine_reply'] }}
							</text>
						</view>
					</view>

				</view>
				<view class="row">
					<view class="col-12">
						<view class="btn_box">
							<button class="btn_submit primary_btn" @click="submit()">提交</button>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";
export default {
	mixins:[mixin],
	components:{},
	data(){
		return{
			url_get_obj:"~/api/purchase_vip/get_obj?",
			url_add:"~/api/purchase_vip/add?",
			url_set:"~/api/purchase_vip/set?",

			// 登录权限
			oauth: {
				"signIn": true,
				"user_group": []
			},

			// 查询条件
			query: {
					"book_number": "",
						"book_name": "",
						"book_category": "",
						"author": "",
						"vip_price": "",
						"user_number": 0,
						"full_name": "",
						"telephone": "",
					"purchase_vip_id": 0
			},

			obj: {
					"book_number":  '', // 图书编号
						"book_name":  '', // 图书名称
						"book_category":  '', // 图书类别
						"author":  '', // 作者
						"vip_price":  '', // VIP价格
						"user_number": 0, // 用户编号
						"full_name":  '', // 姓名
						"telephone":  '', // 电话
					"examine_state": "未审核",
				"examine_reply": "",
				"purchase_vip_id": 0,

			},

			// 表单字段
			form: {
					"book_number":  '', // 图书编号
						"book_name":  '', // 图书名称
						"book_category":  '', // 图书类别
						"author":  '', // 作者
						"vip_price":  '', // VIP价格
						"user_number": 0, // 用户编号
						"full_name":  '', // 姓名
						"telephone":  '', // 电话
					"examine_state": "未审核",
				"examine_reply": "",
				"purchase_vip_id": 0,
			},
			disabledObj:{
					"book_number_isDisabled": false,
						"book_name_isDisabled": false,
						"book_category_isDisabled": false,
						"author_isDisabled": false,
						"vip_price_isDisabled": false,
						"user_number_isDisabled": false,
						"full_name_isDisabled": false,
						"telephone_isDisabled": false,
				},

															// 用户列表
			list_user_user_number: [],
					
			field:"purchase_vip_id",
			table_key:"purchase_vip",

	list_examine_state:[{value:"未审核",text:"未审核"},{value:"已通过",text:"已通过"},{value:"未通过",text:"未通过"}],
		}
	},
	methods: {
			
	
				
	
				
	
				
	
				
	
					/**
		 * 获取注册用户用户列表
		 */
		async get_list_user_user_number() {
			// if(this.user_group !== "管理员" && this.form["user_number"] === 0) {
			//     this.form["user_number"] = this.user.user_id;
			// }
			var json = await this.$get("~/api/user/get_list?user_group=注册用户");
			if(json.result && json.result.list){
				json.result.list.map((o) => this.list_user_user_number.push({value:o.user_id,text:o.nickname + '-' + o.username}));
			}
			else if(json.error){
				console.error(json.error);
			}
		},
				async get_user_session_user_number(){
			var _this = this;
			var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
			if(json.result && json.result.obj){
				var source_table = json.result.obj.source_table;
				var user_id = _this.$store.state.user.user_id;
				if (user_id){
					var url = "~/api/"+source_table+"/get_obj?"
					this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
						if (res.result && res.result.obj) {
							var arr = []
							for (let key in res.result.obj) {
								arr.push(key)
							}
							var arrForm = []
							for (let key in _this.form) {
								arrForm.push(key)
							}
							_this.form["user_number"] = user_id
							_this.disabledObj['user_number' + '_isDisabled'] = true
							for (var i=0;i<arr.length;i++){
                if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                  for (var j = 0; j < arrForm.length; j++) {
                    if (arr[i] === arrForm[j]) {
                      if (arr[i] !== "user_number") {
                        _this.form[arrForm[j]] = res.result.obj[arr[i]]
                        _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                        break;
                      }
                    }
                  }
                }
							}
						}
					});
				}
			}
			else if(json.error){
				console.error(json.error);
			}
		},
	
	
				
	
				
	
			change_file(key_name){
			var _self = this;
				this.$chooseFile().then(res=>{
					console.log(res)

						const uploadTask = uni.uploadFile({
							url: _self.$fullUrl("/api/feedback/upload?"),
							filePath: res[0].path,
							name: "file",
							formData: {
								i_want_to_customize: "test",
							},
							header: {
								"x-auth-token": _self.$store.state.user.token,
							},
							success: function(uploadFileRes) {
								console.log(uploadFileRes)
								var filename = JSON.parse(uploadFileRes.data).result.url;
								_self.form[key_name] = filename;
							},
						});

						uploadTask.onProgressUpdate(function(res) {
							_self.percent = res.progress;
							console.log("上传进度" + res.progress);
							console.log("已经上传的数据长度" + res.totalBytesSent);
							console.log(
								"预期需要上传的数据总长度" + res.totalBytesExpectedToSend
							);
						});

				})
		},
		change_img(key_name) {
			var _self = this;
			_self.upload_img_flag = false
			// 选择图像方法
			uni.chooseImage({
				count: 1,
				sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				sourceType: ['album'], //从相册选择
				success: function(res) {
					const tempFilePaths = res.tempFilePaths;
					const uploadTask = uni.uploadFile({
						url: _self.$fullUrl('/api/purchase_vip/upload?'),
						filePath: tempFilePaths[0],
						name: 'file',
						formData: {
							'purchase_vip': 'test'
						},
						header: {
							'x-auth-token': _self.$store.state.user.token
						},
						success: function(uploadFileRes) {
							var filename = JSON.parse(uploadFileRes.data).result.url
							var img_url = filename
							_self.form[key_name] = img_url
						}
					});

					uploadTask.onProgressUpdate(function(res) {
						_self.percent = res.progress;
						console.log('上传进度' + res.progress);
						console.log('已经上传的数据长度' + res.totalBytesSent);
						console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
					});
				},
				error: function(e) {
					console.log(e);
				}
			});
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_before(param){
			var form = uni.db.get("form");
			if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
				this.obj = uni.push(this.obj ,form);
				this.form = uni.push(this.form ,form);
			}
			var arr = []
			for (let key in form) {
				arr.push(key)
			}
			for (var i=0;i<arr.length;i++){
				this.disabledObj[arr[i] + '_isDisabled'] = true
			}
																			uni.db.del("form");
			return param;
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_after(json ,func){
			var form = uni.db.get("form");
			var obj = Object.assign({} ,form ,this.obj);
			if (form) {
				this.obj = uni.push(this.obj ,obj);
			}
			if (form) {
				this.form = uni.push(this.form ,form);
			}
			if(func){
				func(json);
			}
		},

	},
	onLoad(){
																			this.get_user_session_user_number();
				this.get_list_user_user_number();
								},
}
</script>

<style scoped>
	input{
		font-size: 10px;
	}

	.form_edit {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
	}

	.left_text {
		flex: 0 0 25%;
		display: flex;
		align-items: center;
	}

	.right_text {
		flex: 0 0 75%;
		border-bottom: 1px solid #eee;
	}
	.right_text.btn_warp{
		border-bottom: 0;
	}

	.btn_submit {
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}

	.btn_submit:hover {
		opacity: 0.5;
	}
	.btn_add_img{
		color: #D3D3D3;
		text-align: center;
		border: 1px solid #eee;
		height: 5rem;
		width: 5rem;
		position: relative;
	}
	.btn_add_img text{
		font-size: 35px;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%,-50%);
	}




</style>
<style scoped>
/*新样式*/
.diy_text_row {
  display: inline-block;
}
.container {
	margin-top:1rem ;
	padding: 1rem;
    -webkit-box-shadow: 0px 0px 0px #888888;
    box-shadow: 0px 0px 0px #888888;
}
.primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
	.btn_submit{
		padding: 0;
		margin-top:1rem ;
	}
	.row-item {
		padding: 10px 10px;
	    background: #f8f6fc;
		margin-bottom: 1rem;
	}
	.diy_field{
		padding-left: 1rem;
	}
	.diy_title{
		align-items: center;
        font-size: 14px;
        color: #333;
	}

	.row-item{
		display: flex !important;
		align-items: baseline;
	}
	.diy_select_flex{
		flex: 1;
	}
	.query_select{
		flex: 1;
		border-color: rgb(229, 229, 229);
		background-color: rgb(255, 255, 255);
		border-radius: 4px;
		box-sizing: border-box;
		flex: 1;
		width: 100%;
		line-height: 2;
		font-size: 14px;
		height: 2.4em;
		min-height: 2.4em;
		display: block;
		outline:none;
	}
</style>

