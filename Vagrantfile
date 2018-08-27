# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  
  # config.vm.box = "ubuntu/trusty64"
	
	config.vm.define "cibuild" do |cibuild|
		cibuild.vm.box = "ubuntu/trusty64"
		cibuild.vm.hostname = "cibuild"
		cibuild.vm.network "private_network", ip: "192.168.44.10"
	end
  
 	config.vm.define "rcbuild" do |rcbuild|
		rcbuild.vm.box = "ubuntu/trusty64"
		rcbuild.vm.hostname = "rcbuild"
		rcbuild.vm.network "private_network", ip: "192.168.44.20"
	end
	
	config.vm.define "testbld" do |testbld|
		testbld.vm.box = "ubuntu/trusty64"
		testbld.vm.hostname = "testbld"
		testbld.vm.network "private_network", ip: "192.168.44.30"
	end
	
end
