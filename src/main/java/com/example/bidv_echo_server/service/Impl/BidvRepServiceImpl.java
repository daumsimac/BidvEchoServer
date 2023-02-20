package com.example.bidv_echo_server.service.Impl;

import com.example.bidv_echo_server.model.FirmInqBeneRepLayer;
import com.example.bidv_echo_server.model.FirmInqBeneReqLayer;
import com.example.bidv_echo_server.model.FundTransRepLayout;
import com.example.bidv_echo_server.model.FundTransReqLayout;
import com.example.bidv_echo_server.service.BidvRepService;
import org.springframework.stereotype.Service;

@Service
public class BidvRepServiceImpl implements BidvRepService {

    @Override
    public FirmInqBeneRepLayer replyInquireBeneficiary(FirmInqBeneReqLayer req) throws Exception {
        FirmInqBeneRepLayer rep = null;
        if(req.getOrgCode().equals("0123456")) {
            rep = new FirmInqBeneRepLayer();
            rep.setClientMessageId(req.getClientMessageId());
            rep.setTransactionId(req.getTransactionId());
            rep.setMerchantId(req.getMerchantId());
            rep.setOrgCode(req.getOrgCode());
            rep.setProviderId(req.getProviderId());
            rep.setServiceId(req.getServiceId());
            rep.setCreditBankId(req.getCreditBankId());
            rep.setCreditName("adfsdfsg");
            rep.setStatus(200);
        }else if(req.getOrgCode().equals("0123457")){
            rep = new FirmInqBeneRepLayer();
            rep.setClientMessageId(req.getClientMessageId());
            rep.setTransactionId(req.getTransactionId());
            rep.setMerchantId(req.getMerchantId());
            rep.setOrgCode(req.getOrgCode());
            rep.setProviderId(req.getProviderId());
            rep.setServiceId(req.getServiceId());
            rep.setCreditBankId(req.getCreditBankId());
            rep.setCreditName("");
            rep.setBusinessErrorCode("500");
            rep.setBusinessErrorDesc("Org Mismatch");
            rep.setStatus(500);
        }else{
            rep = new FirmInqBeneRepLayer();
            rep.setClientMessageId(req.getClientMessageId());
            rep.setTransactionId(req.getTransactionId());
            rep.setMerchantId(req.getMerchantId());
            rep.setOrgCode(req.getOrgCode());
            rep.setProviderId(req.getProviderId());
            rep.setServiceId(req.getServiceId());
            rep.setCreditBankId(req.getCreditBankId());
            rep.setCreditName("");
            rep.setBusinessErrorCode("400");
            rep.setBusinessErrorDesc("Org unavailable");
            rep.setStatus(400);
        }

        return rep;
    }

    @Override
    public FundTransRepLayout replyFundTransfer(FundTransReqLayout req) throws Exception {
        FundTransRepLayout rep = null;

        rep = new FundTransRepLayout();
        rep.setClientMessageId(req.getClientMessageId());
        rep.setProviderId(req.getProviderId());
        rep.setOrgCode(req.getOrgCode());
        rep.setMerchantId(req.getMerchantId());
        rep.setServiceId(req.getServiceId());
        rep.setTransStatus("200");
        rep.setBusinessErrorCode("200");
        rep.setBusinessErrorDesc("NORMAL");
        rep.setProcessedRecord(req.getProcessedRecord());
        rep.setTr_info(rep.getTr_info());
        return rep;
    }
}
