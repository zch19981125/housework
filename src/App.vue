<template>
  <div class="layout">
    <Layout>
      <Sider hide-trigger :style="{background: '#fff',height: '100vh', left: 0, overflow: 'auto'}">
        <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
          <MenuItem name="2" :style="{marginTop: '3vh'}" to="serviceList">
            <Icon type="ios-thumbs-up"/>
            工作服务</MenuItem>
          <MenuItem name="3" to="moneyReportList" >
            <Icon type="md-document" />
            日常上报</MenuItem>
          <MenuItem name="4" to="servicePeopleList">
            <Icon type="md-contacts" />
            工作人员</MenuItem>
          <MenuItem name="5" to="customerList">
            <Icon type="md-person-add" />
            客户</MenuItem>
          <Submenu name="6">
            <template slot="title">
              <Icon type="ios-keypad"></Icon>
              统计分析
            </template>
            <MenuItem name="6-1">工资</MenuItem>
            <MenuItem name="6-2">日常杂费</MenuItem>
            <MenuItem name="6-3">统计</MenuItem>
          </Submenu>
          <Submenu name="1">
            <template slot="title">
              <Icon type="ios-albums" />
              字典
            </template>
            <MenuItem name="1-1"  to="dictList">工作服务字典</MenuItem>
            <MenuItem name="1-2" to="ReposDictList">日常杂费字典</MenuItem>
          </Submenu>
        </Menu>
      </Sider>
      <Layout :style="{marginLeft: '3px'}">
        <Header :style="{maxHeight: '5vh',background: '#FFF',lineHeight: '5vh',marginTop: '3px'}">
          <span :style="{marginLeft: '60vh'}">鸿远家政</span>
          <Icon type="ios-body" :style="{marginRight: '11px'}" size="20"/>
        </Header>
        <Content :style="{background: 'rgba(241,233,233,0.34)', height: '95vh',marginTop: '3px'}"><router-view></router-view></Content>
      </Layout>
    </Layout>
  </div>
</template>
<script>
export default {
  name: 'App'
}
</script>

<style>
.layout {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
  min-height: 100vh;
}

.layout-logo {
  width: 100px;
  height: 30px;
  background: #1e1d1b;
  border-radius: 3px;
  float: left;
  position: relative;
  top: 15px;
  left: 20px;
}

.layout-nav {
  width: 420px;
  margin: 0 auto;
  margin-right: 20px;
}

.layout-footer-center {
  text-align: center;
}
</style>
