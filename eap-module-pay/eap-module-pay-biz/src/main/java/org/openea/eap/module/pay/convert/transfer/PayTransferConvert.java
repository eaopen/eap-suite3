package org.openea.eap.module.pay.convert.transfer;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.framework.pay.core.client.dto.transfer.PayTransferUnifiedReqDTO;
import org.openea.eap.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import org.openea.eap.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import org.openea.eap.module.pay.controller.admin.transfer.vo.PayTransferCreateReqVO;
import org.openea.eap.module.pay.controller.admin.transfer.vo.PayTransferPageItemRespVO;
import org.openea.eap.module.pay.controller.admin.transfer.vo.PayTransferRespVO;
import org.openea.eap.module.pay.dal.dataobject.transfer.PayTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayTransferConvert {

    PayTransferConvert INSTANCE = Mappers.getMapper(PayTransferConvert.class);

    PayTransferDO convert(PayTransferCreateReqDTO dto);

    PayTransferUnifiedReqDTO convert2(PayTransferDO dto);

    PayTransferCreateReqDTO convert(PayTransferCreateReqVO vo);

    PayTransferCreateReqDTO convert(PayDemoTransferCreateReqVO vo);

    PayTransferRespVO  convert(PayTransferDO bean);

    PageResult<PayTransferPageItemRespVO> convertPage(PageResult<PayTransferDO> pageResult);
}
