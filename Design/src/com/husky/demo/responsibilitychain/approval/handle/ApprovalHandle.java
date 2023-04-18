package com.husky.demo.responsibilitychain.approval.handle;

public interface ApprovalHandle {

    void next(ApprovalHandle approveHandle);

    boolean doHandle(Integer memory);

}
