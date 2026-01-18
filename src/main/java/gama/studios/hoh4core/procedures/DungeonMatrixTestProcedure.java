package gama.studios.hoh4core.procedures;

public class DungeonMatrixTestProcedure {
	public static void execute() {
		double succes_1_1 = 0;
		double a_1_1 = 0;
		double bigA_1_1 = 0;
		double b_1_1 = 0;
		double bigB_1_1 = 0;
		double composite_1_1 = 0;
		double index_1_1 = 0;
		double randVal_1_1 = 0;
		succes_1_1 = 0;
		a_1_1 = Math.random();
		if (a_1_1 < 0.1) {
			bigA_1_1 = 0;
		} else {
			if (a_1_1 < 0.2) {
				bigA_1_1 = 1;
			} else {
				if (a_1_1 < 0.3) {
					bigA_1_1 = 2;
				} else {
					if (a_1_1 < 0.4) {
						bigA_1_1 = 3;
					} else {
						if (a_1_1 < 0.5) {
							bigA_1_1 = 4;
						} else {
							if (a_1_1 < 0.6) {
								bigA_1_1 = 5;
							} else {
								if (a_1_1 < 0.7) {
									bigA_1_1 = 6;
								} else {
									if (a_1_1 < 0.8) {
										bigA_1_1 = 7;
									} else {
										if (a_1_1 < 0.9) {
											bigA_1_1 = 8;
										} else {
											bigA_1_1 = 9;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		b_1_1 = Math.random();
		if (b_1_1 < 0.1) {
			bigB_1_1 = 0;
		} else {
			if (b_1_1 < 0.2) {
				bigB_1_1 = 1;
			} else {
				if (b_1_1 < 0.3) {
					bigB_1_1 = 2;
				} else {
					if (b_1_1 < 0.4) {
						bigB_1_1 = 3;
					} else {
						if (b_1_1 < 0.5) {
							bigB_1_1 = 4;
						} else {
							if (b_1_1 < 0.6) {
								bigB_1_1 = 5;
							} else {
								if (b_1_1 < 0.7) {
									bigB_1_1 = 6;
								} else {
									if (b_1_1 < 0.8) {
										bigB_1_1 = 7;
									} else {
										if (b_1_1 < 0.9) {
											bigB_1_1 = 8;
										} else {
											bigB_1_1 = 9;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		composite_1_1 = bigA_1_1 * bigB_1_1;
		if (b_1_1 < 0.1) {
			bigB_1_1 = 0;
		} else {
			if (composite_1_1 < 8) {
				index_1_1 = 1;
			} else {
				if (composite_1_1 < 16) {
					index_1_1 = 2;
				} else {
					if (composite_1_1 < 25) {
						index_1_1 = 3;
					} else {
						if (composite_1_1 < 33) {
							index_1_1 = 4;
						} else {
							if (composite_1_1 < 41) {
								index_1_1 = 5;
							} else {
								if (composite_1_1 < 50) {
									index_1_1 = 6;
								} else {
									if (composite_1_1 < 58) {
										index_1_1 = 7;
									} else {
										if (composite_1_1 < 66) {
											index_1_1 = 8;
										} else {
											if (composite_1_1 < 75) {
												index_1_1 = 9;
											} else {
												if (composite_1_1 < 83) {
													index_1_1 = 10;
												} else {
													if (composite_1_1 < 91) {
														index_1_1 = 11;
													} else {
														index_1_1 = 12;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
