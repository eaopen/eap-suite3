package org.openea.eap.module.pay.convert.wallet;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.module.pay.controller.admin.wallet.vo.transaction.PayWalletTransactionRespVO;
import org.openea.eap.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import org.openea.eap.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import org.openea.eap.module.pay.service.wallet.bo.WalletTransactionCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<PayWalletTransactionRespVO> convertPage2(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(WalletTransactionCreateReqBO bean);

}
