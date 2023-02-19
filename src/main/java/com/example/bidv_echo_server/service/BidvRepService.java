package com.example.bidv_echo_server.service;

import com.example.bidv_echo_server.model.FirmInqBeneRepLayer;
import com.example.bidv_echo_server.model.FirmInqBeneReqLayer;
import com.example.bidv_echo_server.model.FundTransRepLayout;
import com.example.bidv_echo_server.model.FundTransReqLayout;

public interface BidvRepService {

    /**
     * 예금주조회 응답전문 - 베트남
     *
     * @param req
     * @return
     * @throws Exception
     */
    public FirmInqBeneRepLayer replyInquireBeneficiary(FirmInqBeneReqLayer req) throws Exception;

    /**
     * 송금 응답전문 - 베트남
     *
     * @param req
     * @return
     * @throws Exception
     */
    public FundTransRepLayout replyFundTransfer(FundTransReqLayout req) throws Exception;
}
