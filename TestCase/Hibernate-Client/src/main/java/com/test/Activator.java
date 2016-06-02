
package com.test;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import services.VehicleService;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
    	VehicleService service = (VehicleService)context.getService(context.getServiceReference(VehicleService.class));
        try {
            service.insertVehicle();
            
            service.getVehicleData();
        } catch (Exception e) {
	    	  e.printStackTrace();
        }
    }

    public void stop(BundleContext context) throws Exception {
    }
    
}
