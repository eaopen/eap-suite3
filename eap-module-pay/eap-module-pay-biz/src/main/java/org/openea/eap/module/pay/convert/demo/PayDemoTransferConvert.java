package org.openea.eap.module.pay.convert.demo;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import org.openea.eap.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferRespVO;
import org.openea.eap.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jason
 */
@Mapper
public interface PayDemoTransferConvert {

    PayDemoTransferConvert INSTANCE = Mappers.getMapper(PayDemoTransferConvert.class);

    PayDemoTransferDO convert(PayDemoTransferCreateReqVO bean);

    PageResult<PayDemoTransferRespVO> convertPage(PageResult<PayDemoTransferDO> pageResult);
}
