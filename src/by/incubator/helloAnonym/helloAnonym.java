package by.incubator.helloAnonym;

public class helloAnonym {
    public static void main(String[] args) {
        MonitoringSystem generalIndicatorsMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Monitoring of general indicators has started!");
            }
        };
        generalIndicatorsMonitoringModule.startMonitoring();

        MonitoringSystem errorMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Bug tracking monitoring has started!");
            }
        };
        errorMonitoringModule.startMonitoring();

        MonitoringSystem securityModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Security monitoring has started!");
            }
        };
        securityModule.startMonitoring();
    }
}
