package com.husky.demo.responsibilitychain.approval.handle;

public class DepartmentLeader implements ApprovalHandle {
    protected ApprovalHandle handle;

    @Override
    public void next(ApprovalHandle approveHandle) {
        this.handle = approveHandle;
    }


    @Override
    public boolean doHandle(Integer memory) {
        if (memory < 2000 && memory > 0) {
            System.out.println("我是部门领导,我只能处理小于2000的钱");
            return true;
        }
        return handle.doHandle(memory);
    }
}
