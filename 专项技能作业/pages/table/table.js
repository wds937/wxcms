Page({
  data: {
    jcs: ["时间","一二节", "三四节", "午休", "五六节", "七八节"],
    kcData: [
      ["周一","-","-","-","-","-"],
      ["周二", "-", "-", "-", "-", "-"],
      ["周三", "-", "-", "-", "-", "-"],
      ["周四", "-", "-", "-", "-", "-"],
      ["周五", "-", "-", "-", "-", "-"],
    ]
  },
  onLoad: function () {
    console.log('onLoad')
    
    //关闭本列表的红点
    wx.hideTabBarRedDot({
      index: 1,
    });
    
  }

})