<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','book_number') || ($check_field('add','book_number') || $check_field('set','book_number'))" label="图书编号" name="book_number">
                            <uni-easyinput type="text" v-model="form['book_number']" v-if="user_group === '管理员' || (form['online_reading_id'] && $check_field('set','book_number')) || (!form['online_reading_id'] && $check_field('add','book_number'))" :disabled="disabledObj['book_number_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','book_number')">
                  {{ form['book_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','book_name') || ($check_field('add','book_name') || $check_field('set','book_name'))" label="图书名称" name="book_name">
                            <uni-easyinput type="text" v-model="form['book_name']" v-if="user_group === '管理员' || (form['online_reading_id'] && $check_field('set','book_name')) || (!form['online_reading_id'] && $check_field('add','book_name'))" :disabled="disabledObj['book_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','book_name')">
                  {{ form['book_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','book_category') || ($check_field('add','book_category') || $check_field('set','book_category'))" label="图书类别" name="book_category">
                            <uni-easyinput type="text" v-model="form['book_category']" v-if="user_group === '管理员' || (form['online_reading_id'] && $check_field('set','book_category')) || (!form['online_reading_id'] && $check_field('add','book_category'))" :disabled="disabledObj['book_category_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','book_category')">
                  {{ form['book_category'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','author') || ($check_field('add','author') || $check_field('set','author'))" label="作者" name="author">
                            <uni-easyinput type="text" v-model="form['author']" v-if="user_group === '管理员' || (form['online_reading_id'] && $check_field('set','author')) || (!form['online_reading_id'] && $check_field('add','author'))" :disabled="disabledObj['author_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','author')">
                  {{ form['author'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','chapter') || ($check_field('add','chapter') || $check_field('set','chapter'))" label="章节" name="chapter">
                            <uni-easyinput type="text" v-model="form['chapter']" v-if="user_group === '管理员' || (form['online_reading_id'] && $check_field('set','chapter')) || (!form['online_reading_id'] && $check_field('add','chapter'))" :disabled="disabledObj['chapter_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','chapter')">
                  {{ form['chapter'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','content') || ($check_field('add','content') || $check_field('set','content'))" label="内容" name="content">
                    <uni-easyinput type="textarea" v-model="form['content']" v-if="user_group === '管理员' || (form['online_reading_id'] && $check_field('set','content')) || (!form['online_reading_id'] && $check_field('add','content'))" :disabled="disabledObj['content_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','content')">
                  {{ form['content'] }}
                </text>
                  </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
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
  mixins: [mixin],
  data() {
    return {
      field: "online_reading_id",
      url_add: "~/api/online_reading/add?",
      url_set: "~/api/online_reading/set?",
      url_get_obj: "~/api/online_reading/get_obj?",
      url_upload: "~/api/online_reading/upload?",

      query: {
        "online_reading_id": 0,
      },

      form: {
            "book_number":  '', // 图书编号
                    "book_name":  '', // 图书名称
                    "book_category":  '', // 图书类别
                    "author":  '', // 作者
                    "chapter":  '', // 章节
                    "content":  '', // 内容
                                "online_reading_id": 0, // ID
                
              },
          disabledObj:{
                        "book_number_isDisabled": false,
                                "book_name_isDisabled": false,
                                "book_category_isDisabled": false,
                                "author_isDisabled": false,
                                "chapter_isDisabled": false,
                                "content_isDisabled": false,
                                  },
                                                                                                                                              }
  },
  methods: {
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/online_reading/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
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
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
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
            url: _self.$fullUrl('/api/online_reading/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
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
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                    },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/online_reading/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/online_reading/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/online_reading/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/online_reading/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/online_reading/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                                                  },
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
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

.query_option{
  width: 100%;
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
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
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
