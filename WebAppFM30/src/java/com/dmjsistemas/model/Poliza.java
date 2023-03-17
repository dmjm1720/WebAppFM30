package com.dmjsistemas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POLIZA", schema = "dbo", catalog = "DBFM30"
)
public class Poliza implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVOUCHER")
    private int idvoucher;

    @Column(name = "VOUCHER_NO", length = 5)
    private String voucherNo;

    @Column(name = "ENTRY_DATE", length = 10)
    private String entryDate;

    @Column(name = "TRANSACTION_DATE", length = 10)
    private String transactionDate;

    @Column(name = "CURRENCY", length = 10)
    private String currency;

    @Column(name = "RATE", length = 50)
    private String rate;

    @Column(name = "REMARKS", length = 250)
    private String remarks;

    @Column(name = "DRCR", length = 10)
    private String drcr;

    @Column(name = "UNIT", length = 50)
    private String unit;

    @Column(name = "ACCOUNT", length = 50)
    private String account;

    @Column(name = "TAX_CODE", length = 10)
    private String taxCode;

    @Column(name = "TF", length = 10)
    private String tf;

    @Column(name = "SUB_ACCOUNT", length = 50)
    private String subAccount;

    @Column(name = "CONTRACT_NO", length = 50)
    private String contractNo;

    @Column(name = "REFERENCE_NO", length = 250)
    private String referenceNo;

    @Column(name = "DUE_DATE", length = 10)
    private String dueDate;

    @Column(name = "AMOUNT", length = 50)
    private String amount;

    @Column(name = "USER_FOLIO", length = 30)
    private String userFolio;

    @Column(name = "USER_NAME", length = 50)
    private String userName;

    public Poliza() {
    }

    public Poliza(int idvoucher) {
        this.idvoucher = idvoucher;
    }

    public Poliza(int idvoucher, String voucherNo, String entryDate, String transactionDate, String currency, String rate, String remarks, String drcr, String unit, String account, String taxCode, String tf, String subAccount, String contractNo, String referenceNo, String dueDate, String amount, String userFolio, String userName) {
        this.idvoucher = idvoucher;
        this.voucherNo = voucherNo;
        this.entryDate = entryDate;
        this.transactionDate = transactionDate;
        this.currency = currency;
        this.rate = rate;
        this.remarks = remarks;
        this.drcr = drcr;
        this.unit = unit;
        this.account = account;
        this.taxCode = taxCode;
        this.tf = tf;
        this.subAccount = subAccount;
        this.contractNo = contractNo;
        this.referenceNo = referenceNo;
        this.dueDate = dueDate;
        this.amount = amount;
        this.userFolio = userFolio;
        this.userName = userName;
    }

    public int getIdvoucher() {
        return this.idvoucher;
    }

    public void setIdvoucher(int idvoucher) {
        this.idvoucher = idvoucher;
    }

    public String getVoucherNo() {
        return this.voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDrcr() {
        return this.drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTaxCode() {
        return this.taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTf() {
        return this.tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public String getSubAccount() {
        return this.subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public String getContractNo() {
        return this.contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getReferenceNo() {
        return this.referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserFolio() {
        return this.userFolio;
    }

    public void setUserFolio(String userFolio) {
        this.userFolio = userFolio;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
