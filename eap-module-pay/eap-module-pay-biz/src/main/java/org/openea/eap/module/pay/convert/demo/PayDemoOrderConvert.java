package org.openea.eap.module.pay.convert.demo;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.module.pay.controller.admin.demo.vo.order.PayDemoOrderCreateReqVO;
import org.openea.eap.module.pay.controller.admin.demo.vo.order.PayDemoOrderRespVO;
import org.openea.eap.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}
