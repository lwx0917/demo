package com.husky.demo.responsibilitychain.approval;

import com.husky.demo.responsibilitychain.approval.handle.ApprovalHandle;
import com.husky.demo.responsibilitychain.approval.handle.Boss;
import com.husky.demo.responsibilitychain.approval.handle.DepartmentLeader;
import com.husky.demo.responsibilitychain.approval.handle.Manager;

public class Client {

    public static void main(String[] args) {
        ApprovalHandle leader = new DepartmentLeader();
        ApprovalHandle manager = new Manager();
        ApprovalHandle boss = new Boss();
        leader.next(manager);
        manager.next(boss);
        leader.doHandle(10000000);
    }
}
