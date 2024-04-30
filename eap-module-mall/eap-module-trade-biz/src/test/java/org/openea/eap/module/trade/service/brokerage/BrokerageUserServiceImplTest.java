package org.openea.eap.module.trade.service.brokerage;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.framework.test.core.ut.BaseDbUnitTest;
import org.openea.eap.module.trade.controller.admin.brokerage.vo.user.BrokerageUserPageReqVO;
import org.openea.eap.module.trade.dal.dataobject.brokerage.BrokerageUserDO;
import org.openea.eap.module.trade.dal.mysql.brokerage.BrokerageUserMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static org.openea.eap.framework.common.util.date.LocalDateTimeUtils.buildBetweenTime;
import static org.openea.eap.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static org.openea.eap.framework.test.core.util.AssertUtils.assertPojoEquals;
import static org.openea.eap.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO @芋艿：单测后续看看
/**
 * {@link BrokerageUserServiceImpl} 的单元测试类
 *
 * @author owen
 */
@Disabled // TODO 芋艿：后续 fix 补充的单测
@Import(BrokerageUserServiceImpl.class)
public class BrokerageUserServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BrokerageUserServiceImpl brokerageUserService;

    @Resource
    private BrokerageUserMapper brokerageUserMapper;

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetBrokerageUserPage() {
        // mock 数据
        BrokerageUserDO dbBrokerageUser = randomPojo(BrokerageUserDO.class, o -> { // 等会查询到
            o.setBindUserId(null);
            o.setBrokerageEnabled(null);
            o.setCreateTime(null);
        });
        brokerageUserMapper.insert(dbBrokerageUser);
        // 测试 brokerageUserId 不匹配
        brokerageUserMapper.insert(cloneIgnoreId(dbBrokerageUser, o -> o.setBindUserId(null)));
        // 测试 brokerageEnabled 不匹配
        brokerageUserMapper.insert(cloneIgnoreId(dbBrokerageUser, o -> o.setBrokerageEnabled(null)));
        // 测试 createTime 不匹配
        brokerageUserMapper.insert(cloneIgnoreId(dbBrokerageUser, o -> o.setCreateTime(null)));
        // 准备参数
        BrokerageUserPageReqVO reqVO = new BrokerageUserPageReqVO();
        reqVO.setBindUserId(null);
        reqVO.setBrokerageEnabled(null);
        reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

        // 调用
        PageResult<BrokerageUserDO> pageResult = brokerageUserService.getBrokerageUserPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbBrokerageUser, pageResult.getList().get(0));
    }

}
