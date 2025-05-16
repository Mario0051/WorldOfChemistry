package mario.worldofchemistry.data;

import java.util.HashMap;
import java.util.Map;

public class AtomicData {

    // Map<AtomicNumber, int[]{Shell1_electrons, Shell2_electrons, ...}>
    public static final Map<Integer, int[]> ELECTRON_CONFIGURATIONS_TABLE = new HashMap<>();
    // Map<AtomicNumber, NeutronCount_for_most_common_isotope>
    public static final Map<Integer, Integer> MOST_COMMON_ISOTOPE_NEUTRONS = new HashMap<>();
    // Map<AtomicNumber, int[]{min_neutron_count, max_neutron_count_for_known_isotopes}>
    public static final Map<Integer, int[]> VALID_ISOTOPE_NEUTRON_RANGES = new HashMap<>();

    static {
        // Populate ELECTRON_CONFIGURATIONS_TABLE (Electrons per shell)
        // Data as provided in the previous response.
        ELECTRON_CONFIGURATIONS_TABLE.put(1, new int[]{1}); // H
        ELECTRON_CONFIGURATIONS_TABLE.put(2, new int[]{2}); // He
        ELECTRON_CONFIGURATIONS_TABLE.put(3, new int[]{2, 1}); // Li
        ELECTRON_CONFIGURATIONS_TABLE.put(4, new int[]{2, 2}); // Be
        ELECTRON_CONFIGURATIONS_TABLE.put(5, new int[]{2, 3}); // B
        ELECTRON_CONFIGURATIONS_TABLE.put(6, new int[]{2, 4}); // C
        ELECTRON_CONFIGURATIONS_TABLE.put(7, new int[]{2, 5}); // N
        ELECTRON_CONFIGURATIONS_TABLE.put(8, new int[]{2, 6}); // O
        ELECTRON_CONFIGURATIONS_TABLE.put(9, new int[]{2, 7}); // F
        ELECTRON_CONFIGURATIONS_TABLE.put(10, new int[]{2, 8}); // Ne
        ELECTRON_CONFIGURATIONS_TABLE.put(11, new int[]{2, 8, 1}); // Na
        ELECTRON_CONFIGURATIONS_TABLE.put(12, new int[]{2, 8, 2}); // Mg
        ELECTRON_CONFIGURATIONS_TABLE.put(13, new int[]{2, 8, 3}); // Al
        ELECTRON_CONFIGURATIONS_TABLE.put(14, new int[]{2, 8, 4}); // Si
        ELECTRON_CONFIGURATIONS_TABLE.put(15, new int[]{2, 8, 5}); // P
        ELECTRON_CONFIGURATIONS_TABLE.put(16, new int[]{2, 8, 6}); // S
        ELECTRON_CONFIGURATIONS_TABLE.put(17, new int[]{2, 8, 7}); // Cl
        ELECTRON_CONFIGURATIONS_TABLE.put(18, new int[]{2, 8, 8}); // Ar
        ELECTRON_CONFIGURATIONS_TABLE.put(19, new int[]{2, 8, 8, 1}); // K
        ELECTRON_CONFIGURATIONS_TABLE.put(20, new int[]{2, 8, 8, 2}); // Ca
        ELECTRON_CONFIGURATIONS_TABLE.put(21, new int[]{2, 8, 9, 2}); // Sc
        ELECTRON_CONFIGURATIONS_TABLE.put(22, new int[]{2, 8, 10, 2}); // Ti
        ELECTRON_CONFIGURATIONS_TABLE.put(23, new int[]{2, 8, 11, 2}); // V
        ELECTRON_CONFIGURATIONS_TABLE.put(24, new int[]{2, 8, 13, 1}); // Cr
        ELECTRON_CONFIGURATIONS_TABLE.put(25, new int[]{2, 8, 13, 2}); // Mn
        ELECTRON_CONFIGURATIONS_TABLE.put(26, new int[]{2, 8, 14, 2}); // Fe
        ELECTRON_CONFIGURATIONS_TABLE.put(27, new int[]{2, 8, 15, 2}); // Co
        ELECTRON_CONFIGURATIONS_TABLE.put(28, new int[]{2, 8, 16, 2}); // Ni
        ELECTRON_CONFIGURATIONS_TABLE.put(29, new int[]{2, 8, 18, 1}); // Cu
        ELECTRON_CONFIGURATIONS_TABLE.put(30, new int[]{2, 8, 18, 2}); // Zn
        ELECTRON_CONFIGURATIONS_TABLE.put(31, new int[]{2, 8, 18, 3}); // Ga
        ELECTRON_CONFIGURATIONS_TABLE.put(32, new int[]{2, 8, 18, 4}); // Ge
        ELECTRON_CONFIGURATIONS_TABLE.put(33, new int[]{2, 8, 18, 5}); // As
        ELECTRON_CONFIGURATIONS_TABLE.put(34, new int[]{2, 8, 18, 6}); // Se
        ELECTRON_CONFIGURATIONS_TABLE.put(35, new int[]{2, 8, 18, 7}); // Br
        ELECTRON_CONFIGURATIONS_TABLE.put(36, new int[]{2, 8, 18, 8}); // Kr
        ELECTRON_CONFIGURATIONS_TABLE.put(37, new int[]{2, 8, 18, 8, 1}); // Rb
        ELECTRON_CONFIGURATIONS_TABLE.put(38, new int[]{2, 8, 18, 8, 2}); // Sr
        ELECTRON_CONFIGURATIONS_TABLE.put(39, new int[]{2, 8, 18, 9, 2}); // Y
        ELECTRON_CONFIGURATIONS_TABLE.put(40, new int[]{2, 8, 18, 10, 2}); // Zr
        ELECTRON_CONFIGURATIONS_TABLE.put(41, new int[]{2, 8, 18, 12, 1}); // Nb
        ELECTRON_CONFIGURATIONS_TABLE.put(42, new int[]{2, 8, 18, 13, 1}); // Mo
        ELECTRON_CONFIGURATIONS_TABLE.put(43, new int[]{2, 8, 18, 13, 2}); // Tc
        ELECTRON_CONFIGURATIONS_TABLE.put(44, new int[]{2, 8, 18, 15, 1}); // Ru
        ELECTRON_CONFIGURATIONS_TABLE.put(45, new int[]{2, 8, 18, 16, 1}); // Rh
        ELECTRON_CONFIGURATIONS_TABLE.put(46, new int[]{2, 8, 18, 18});    // Pd
        ELECTRON_CONFIGURATIONS_TABLE.put(47, new int[]{2, 8, 18, 18, 1}); // Ag
        ELECTRON_CONFIGURATIONS_TABLE.put(48, new int[]{2, 8, 18, 18, 2}); // Cd
        ELECTRON_CONFIGURATIONS_TABLE.put(49, new int[]{2, 8, 18, 18, 3}); // In
        ELECTRON_CONFIGURATIONS_TABLE.put(50, new int[]{2, 8, 18, 18, 4}); // Sn
        ELECTRON_CONFIGURATIONS_TABLE.put(51, new int[]{2, 8, 18, 18, 5}); // Sb
        ELECTRON_CONFIGURATIONS_TABLE.put(52, new int[]{2, 8, 18, 18, 6}); // Te
        ELECTRON_CONFIGURATIONS_TABLE.put(53, new int[]{2, 8, 18, 18, 7}); // I
        ELECTRON_CONFIGURATIONS_TABLE.put(54, new int[]{2, 8, 18, 18, 8}); // Xe
        ELECTRON_CONFIGURATIONS_TABLE.put(55, new int[]{2, 8, 18, 18, 8, 1}); // Cs
        ELECTRON_CONFIGURATIONS_TABLE.put(56, new int[]{2, 8, 18, 18, 8, 2}); // Ba
        ELECTRON_CONFIGURATIONS_TABLE.put(57, new int[]{2, 8, 18, 18, 9, 2}); // La
        ELECTRON_CONFIGURATIONS_TABLE.put(58, new int[]{2, 8, 18, 19, 9, 2}); // Ce
        ELECTRON_CONFIGURATIONS_TABLE.put(59, new int[]{2, 8, 18, 21, 8, 2}); // Pr
        ELECTRON_CONFIGURATIONS_TABLE.put(60, new int[]{2, 8, 18, 22, 8, 2}); // Nd
        ELECTRON_CONFIGURATIONS_TABLE.put(61, new int[]{2, 8, 18, 23, 8, 2}); // Pm
        ELECTRON_CONFIGURATIONS_TABLE.put(62, new int[]{2, 8, 18, 24, 8, 2}); // Sm
        ELECTRON_CONFIGURATIONS_TABLE.put(63, new int[]{2, 8, 18, 25, 8, 2}); // Eu
        ELECTRON_CONFIGURATIONS_TABLE.put(64, new int[]{2, 8, 18, 25, 9, 2}); // Gd
        ELECTRON_CONFIGURATIONS_TABLE.put(65, new int[]{2, 8, 18, 27, 8, 2}); // Tb
        ELECTRON_CONFIGURATIONS_TABLE.put(66, new int[]{2, 8, 18, 28, 8, 2}); // Dy
        ELECTRON_CONFIGURATIONS_TABLE.put(67, new int[]{2, 8, 18, 29, 8, 2}); // Ho
        ELECTRON_CONFIGURATIONS_TABLE.put(68, new int[]{2, 8, 18, 30, 8, 2}); // Er
        ELECTRON_CONFIGURATIONS_TABLE.put(69, new int[]{2, 8, 18, 31, 8, 2}); // Tm
        ELECTRON_CONFIGURATIONS_TABLE.put(70, new int[]{2, 8, 18, 32, 8, 2}); // Yb
        ELECTRON_CONFIGURATIONS_TABLE.put(71, new int[]{2, 8, 18, 32, 9, 2}); // Lu
        ELECTRON_CONFIGURATIONS_TABLE.put(72, new int[]{2, 8, 18, 32, 10, 2}); // Hf
        ELECTRON_CONFIGURATIONS_TABLE.put(73, new int[]{2, 8, 18, 32, 11, 2}); // Ta
        ELECTRON_CONFIGURATIONS_TABLE.put(74, new int[]{2, 8, 18, 32, 12, 2}); // W
        ELECTRON_CONFIGURATIONS_TABLE.put(75, new int[]{2, 8, 18, 32, 13, 2}); // Re
        ELECTRON_CONFIGURATIONS_TABLE.put(76, new int[]{2, 8, 18, 32, 14, 2}); // Os
        ELECTRON_CONFIGURATIONS_TABLE.put(77, new int[]{2, 8, 18, 32, 15, 2}); // Ir
        ELECTRON_CONFIGURATIONS_TABLE.put(78, new int[]{2, 8, 18, 32, 17, 1}); // Pt
        ELECTRON_CONFIGURATIONS_TABLE.put(79, new int[]{2, 8, 18, 32, 18, 1}); // Au
        ELECTRON_CONFIGURATIONS_TABLE.put(80, new int[]{2, 8, 18, 32, 18, 2}); // Hg
        ELECTRON_CONFIGURATIONS_TABLE.put(81, new int[]{2, 8, 18, 32, 18, 3}); // Tl
        ELECTRON_CONFIGURATIONS_TABLE.put(82, new int[]{2, 8, 18, 32, 18, 4}); // Pb
        ELECTRON_CONFIGURATIONS_TABLE.put(83, new int[]{2, 8, 18, 32, 18, 5}); // Bi
        ELECTRON_CONFIGURATIONS_TABLE.put(84, new int[]{2, 8, 18, 32, 18, 6}); // Po
        ELECTRON_CONFIGURATIONS_TABLE.put(85, new int[]{2, 8, 18, 32, 18, 7}); // At
        ELECTRON_CONFIGURATIONS_TABLE.put(86, new int[]{2, 8, 18, 32, 18, 8}); // Rn
        ELECTRON_CONFIGURATIONS_TABLE.put(87, new int[]{2, 8, 18, 32, 18, 8, 1}); // Fr
        ELECTRON_CONFIGURATIONS_TABLE.put(88, new int[]{2, 8, 18, 32, 18, 8, 2}); // Ra
        ELECTRON_CONFIGURATIONS_TABLE.put(89, new int[]{2, 8, 18, 32, 18, 9, 2}); // Ac
        ELECTRON_CONFIGURATIONS_TABLE.put(90, new int[]{2, 8, 18, 32, 18, 10, 2});// Th
        ELECTRON_CONFIGURATIONS_TABLE.put(91, new int[]{2, 8, 18, 32, 20, 9, 2}); // Pa
        ELECTRON_CONFIGURATIONS_TABLE.put(92, new int[]{2, 8, 18, 32, 21, 9, 2}); // U
        ELECTRON_CONFIGURATIONS_TABLE.put(93, new int[]{2, 8, 18, 32, 22, 9, 2}); // Np
        ELECTRON_CONFIGURATIONS_TABLE.put(94, new int[]{2, 8, 18, 32, 24, 8, 2}); // Pu
        ELECTRON_CONFIGURATIONS_TABLE.put(95, new int[]{2, 8, 18, 32, 25, 8, 2}); // Am
        ELECTRON_CONFIGURATIONS_TABLE.put(96, new int[]{2, 8, 18, 32, 25, 9, 2}); // Cm
        ELECTRON_CONFIGURATIONS_TABLE.put(97, new int[]{2, 8, 18, 32, 27, 8, 2}); // Bk
        ELECTRON_CONFIGURATIONS_TABLE.put(98, new int[]{2, 8, 18, 32, 28, 8, 2}); // Cf
        ELECTRON_CONFIGURATIONS_TABLE.put(99, new int[]{2, 8, 18, 32, 29, 8, 2}); // Es
        ELECTRON_CONFIGURATIONS_TABLE.put(100, new int[]{2, 8, 18, 32, 30, 8, 2}); // Fm
        ELECTRON_CONFIGURATIONS_TABLE.put(101, new int[]{2, 8, 18, 32, 31, 8, 2}); // Md
        ELECTRON_CONFIGURATIONS_TABLE.put(102, new int[]{2, 8, 18, 32, 32, 8, 2}); // No
        ELECTRON_CONFIGURATIONS_TABLE.put(103, new int[]{2, 8, 18, 32, 32, 9, 2}); // Lr
        ELECTRON_CONFIGURATIONS_TABLE.put(104, new int[]{2, 8, 18, 32, 32, 10, 2}); // Rf
        ELECTRON_CONFIGURATIONS_TABLE.put(105, new int[]{2, 8, 18, 32, 32, 11, 2}); // Db
        ELECTRON_CONFIGURATIONS_TABLE.put(106, new int[]{2, 8, 18, 32, 32, 12, 2}); // Sg
        ELECTRON_CONFIGURATIONS_TABLE.put(107, new int[]{2, 8, 18, 32, 32, 13, 2}); // Bh
        ELECTRON_CONFIGURATIONS_TABLE.put(108, new int[]{2, 8, 18, 32, 32, 14, 2}); // Hs
        ELECTRON_CONFIGURATIONS_TABLE.put(109, new int[]{2, 8, 18, 32, 32, 15, 2}); // Mt
        ELECTRON_CONFIGURATIONS_TABLE.put(110, new int[]{2, 8, 18, 32, 32, 17, 1}); // Ds
        ELECTRON_CONFIGURATIONS_TABLE.put(111, new int[]{2, 8, 18, 32, 32, 17, 2}); // Rg
        ELECTRON_CONFIGURATIONS_TABLE.put(112, new int[]{2, 8, 18, 32, 32, 18, 2}); // Cn
        ELECTRON_CONFIGURATIONS_TABLE.put(113, new int[]{2, 8, 18, 32, 32, 18, 3}); // Nh
        ELECTRON_CONFIGURATIONS_TABLE.put(114, new int[]{2, 8, 18, 32, 32, 18, 4}); // Fl
        ELECTRON_CONFIGURATIONS_TABLE.put(115, new int[]{2, 8, 18, 32, 32, 18, 5}); // Mc
        ELECTRON_CONFIGURATIONS_TABLE.put(116, new int[]{2, 8, 18, 32, 32, 18, 6}); // Lv
        ELECTRON_CONFIGURATIONS_TABLE.put(117, new int[]{2, 8, 18, 32, 32, 18, 7}); // Ts
        ELECTRON_CONFIGURATIONS_TABLE.put(118, new int[]{2, 8, 18, 32, 32, 18, 8}); // Og
        ELECTRON_CONFIGURATIONS_TABLE.put(119, new int[]{2, 8, 18, 32, 32, 18, 8, 1});
        ELECTRON_CONFIGURATIONS_TABLE.put(120, new int[]{2, 8, 18, 32, 32, 18, 8, 2});

        // Populate MOST_COMMON_ISOTOPE_NEUTRONS
        // Data as provided in the previous response.
        MOST_COMMON_ISOTOPE_NEUTRONS.put(1, 0);   // H-1
        MOST_COMMON_ISOTOPE_NEUTRONS.put(2, 2);   // He-4
        MOST_COMMON_ISOTOPE_NEUTRONS.put(3, 4);   // Li-7
        MOST_COMMON_ISOTOPE_NEUTRONS.put(4, 5);   // Be-9
        MOST_COMMON_ISOTOPE_NEUTRONS.put(5, 6);   // B-11
        MOST_COMMON_ISOTOPE_NEUTRONS.put(6, 6);   // C-12
        MOST_COMMON_ISOTOPE_NEUTRONS.put(7, 7);   // N-14
        MOST_COMMON_ISOTOPE_NEUTRONS.put(8, 8);   // O-16
        MOST_COMMON_ISOTOPE_NEUTRONS.put(9, 10);  // F-19
        MOST_COMMON_ISOTOPE_NEUTRONS.put(10, 10); // Ne-20
        MOST_COMMON_ISOTOPE_NEUTRONS.put(11, 12); // Na-23
        MOST_COMMON_ISOTOPE_NEUTRONS.put(12, 12); // Mg-24
        MOST_COMMON_ISOTOPE_NEUTRONS.put(13, 14); // Al-27
        MOST_COMMON_ISOTOPE_NEUTRONS.put(14, 14); // Si-28
        MOST_COMMON_ISOTOPE_NEUTRONS.put(15, 16); // P-31
        MOST_COMMON_ISOTOPE_NEUTRONS.put(16, 16); // S-32
        MOST_COMMON_ISOTOPE_NEUTRONS.put(17, 18); // Cl-35
        MOST_COMMON_ISOTOPE_NEUTRONS.put(18, 22); // Ar-40
        MOST_COMMON_ISOTOPE_NEUTRONS.put(19, 20); // K-39
        MOST_COMMON_ISOTOPE_NEUTRONS.put(20, 20); // Ca-40
        MOST_COMMON_ISOTOPE_NEUTRONS.put(21, 24); // Sc-45
        MOST_COMMON_ISOTOPE_NEUTRONS.put(22, 26); // Ti-48
        MOST_COMMON_ISOTOPE_NEUTRONS.put(23, 28); // V-51
        MOST_COMMON_ISOTOPE_NEUTRONS.put(24, 28); // Cr-52
        MOST_COMMON_ISOTOPE_NEUTRONS.put(25, 30); // Mn-55
        MOST_COMMON_ISOTOPE_NEUTRONS.put(26, 30); // Fe-56
        MOST_COMMON_ISOTOPE_NEUTRONS.put(27, 32); // Co-59
        MOST_COMMON_ISOTOPE_NEUTRONS.put(28, 30); // Ni-58
        MOST_COMMON_ISOTOPE_NEUTRONS.put(29, 34); // Cu-63
        MOST_COMMON_ISOTOPE_NEUTRONS.put(30, 34); // Zn-64
        MOST_COMMON_ISOTOPE_NEUTRONS.put(31, 38); // Ga-69
        MOST_COMMON_ISOTOPE_NEUTRONS.put(32, 42); // Ge-74
        MOST_COMMON_ISOTOPE_NEUTRONS.put(33, 42); // As-75
        MOST_COMMON_ISOTOPE_NEUTRONS.put(34, 46); // Se-80
        MOST_COMMON_ISOTOPE_NEUTRONS.put(35, 44); // Br-79
        MOST_COMMON_ISOTOPE_NEUTRONS.put(36, 48); // Kr-84
        MOST_COMMON_ISOTOPE_NEUTRONS.put(37, 48); // Rb-85
        MOST_COMMON_ISOTOPE_NEUTRONS.put(38, 50); // Sr-88
        MOST_COMMON_ISOTOPE_NEUTRONS.put(39, 50); // Y-89
        MOST_COMMON_ISOTOPE_NEUTRONS.put(40, 50); // Zr-90
        MOST_COMMON_ISOTOPE_NEUTRONS.put(41, 52); // Nb-93
        MOST_COMMON_ISOTOPE_NEUTRONS.put(42, 56); // Mo-98
        MOST_COMMON_ISOTOPE_NEUTRONS.put(43, 55); // Tc-98
        MOST_COMMON_ISOTOPE_NEUTRONS.put(44, 58); // Ru-102
        MOST_COMMON_ISOTOPE_NEUTRONS.put(45, 58); // Rh-103
        MOST_COMMON_ISOTOPE_NEUTRONS.put(46, 60); // Pd-106
        MOST_COMMON_ISOTOPE_NEUTRONS.put(47, 60); // Ag-107
        MOST_COMMON_ISOTOPE_NEUTRONS.put(48, 66); // Cd-114
        MOST_COMMON_ISOTOPE_NEUTRONS.put(49, 66); // In-115
        MOST_COMMON_ISOTOPE_NEUTRONS.put(50, 70); // Sn-120
        MOST_COMMON_ISOTOPE_NEUTRONS.put(51, 70); // Sb-121
        MOST_COMMON_ISOTOPE_NEUTRONS.put(52, 78); // Te-130
        MOST_COMMON_ISOTOPE_NEUTRONS.put(53, 74); // I-127
        MOST_COMMON_ISOTOPE_NEUTRONS.put(54, 77); // Xe-131
        MOST_COMMON_ISOTOPE_NEUTRONS.put(55, 78); // Cs-133
        MOST_COMMON_ISOTOPE_NEUTRONS.put(56, 82); // Ba-138
        MOST_COMMON_ISOTOPE_NEUTRONS.put(57, 82); // La-139
        MOST_COMMON_ISOTOPE_NEUTRONS.put(58, 82); // Ce-140
        MOST_COMMON_ISOTOPE_NEUTRONS.put(59, 82); // Pr-141
        MOST_COMMON_ISOTOPE_NEUTRONS.put(60, 82); // Nd-142
        MOST_COMMON_ISOTOPE_NEUTRONS.put(61, 84); // Pm-145
        MOST_COMMON_ISOTOPE_NEUTRONS.put(62, 90); // Sm-152
        MOST_COMMON_ISOTOPE_NEUTRONS.put(63, 90); // Eu-153
        MOST_COMMON_ISOTOPE_NEUTRONS.put(64, 94); // Gd-158
        MOST_COMMON_ISOTOPE_NEUTRONS.put(65, 94); // Tb-159
        MOST_COMMON_ISOTOPE_NEUTRONS.put(66, 98); // Dy-164
        MOST_COMMON_ISOTOPE_NEUTRONS.put(67, 98); // Ho-165
        MOST_COMMON_ISOTOPE_NEUTRONS.put(68, 100); // Er-166
        MOST_COMMON_ISOTOPE_NEUTRONS.put(69, 100); // Tm-169
        MOST_COMMON_ISOTOPE_NEUTRONS.put(70, 104); // Yb-174
        MOST_COMMON_ISOTOPE_NEUTRONS.put(71, 104); // Lu-175
        MOST_COMMON_ISOTOPE_NEUTRONS.put(72, 108); // Hf-180
        MOST_COMMON_ISOTOPE_NEUTRONS.put(73, 108); // Ta-181
        MOST_COMMON_ISOTOPE_NEUTRONS.put(74, 110); // W-184
        MOST_COMMON_ISOTOPE_NEUTRONS.put(75, 112); // Re-187
        MOST_COMMON_ISOTOPE_NEUTRONS.put(76, 116); // Os-192
        MOST_COMMON_ISOTOPE_NEUTRONS.put(77, 116); // Ir-193
        MOST_COMMON_ISOTOPE_NEUTRONS.put(78, 117); // Pt-195
        MOST_COMMON_ISOTOPE_NEUTRONS.put(79, 118); // Au-197
        MOST_COMMON_ISOTOPE_NEUTRONS.put(80, 122); // Hg-202
        MOST_COMMON_ISOTOPE_NEUTRONS.put(81, 124); // Tl-205
        MOST_COMMON_ISOTOPE_NEUTRONS.put(82, 126); // Pb-208
        MOST_COMMON_ISOTOPE_NEUTRONS.put(83, 126); // Bi-209
        MOST_COMMON_ISOTOPE_NEUTRONS.put(84, 125); // Po-209
        MOST_COMMON_ISOTOPE_NEUTRONS.put(85, 125); // At-210
        MOST_COMMON_ISOTOPE_NEUTRONS.put(86, 136); // Rn-222
        MOST_COMMON_ISOTOPE_NEUTRONS.put(87, 136); // Fr-223
        MOST_COMMON_ISOTOPE_NEUTRONS.put(88, 138); // Ra-226
        MOST_COMMON_ISOTOPE_NEUTRONS.put(89, 138); // Ac-227
        MOST_COMMON_ISOTOPE_NEUTRONS.put(90, 142); // Th-232
        MOST_COMMON_ISOTOPE_NEUTRONS.put(91, 140); // Pa-231
        MOST_COMMON_ISOTOPE_NEUTRONS.put(92, 146); // U-238
        MOST_COMMON_ISOTOPE_NEUTRONS.put(93, 144); // Np-237
        MOST_COMMON_ISOTOPE_NEUTRONS.put(94, 150); // Pu-244
        MOST_COMMON_ISOTOPE_NEUTRONS.put(95, 148); // Am-243
        MOST_COMMON_ISOTOPE_NEUTRONS.put(96, 151); // Cm-247
        MOST_COMMON_ISOTOPE_NEUTRONS.put(97, 150); // Bk-247
        MOST_COMMON_ISOTOPE_NEUTRONS.put(98, 153); // Cf-251
        MOST_COMMON_ISOTOPE_NEUTRONS.put(99, 153); // Es-252
        MOST_COMMON_ISOTOPE_NEUTRONS.put(100, 157); // Fm-257
        MOST_COMMON_ISOTOPE_NEUTRONS.put(101, 157); // Md-258
        MOST_COMMON_ISOTOPE_NEUTRONS.put(102, 157); // No-259
        MOST_COMMON_ISOTOPE_NEUTRONS.put(103, 159); // Lr-262
        MOST_COMMON_ISOTOPE_NEUTRONS.put(104, 163); // Rf-267 (Rf-265 also known)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(105, 163); // Db-268 (Db-270 new longest)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(106, 165); // Sg-271 (Sg-269 also)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(107, 163); // Bh-270
        MOST_COMMON_ISOTOPE_NEUTRONS.put(108, 169); // Hs-277 (Hs-270 also)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(109, 169); // Mt-278 (Mt-276 also)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(110, 171); // Ds-281
        MOST_COMMON_ISOTOPE_NEUTRONS.put(111, 171); // Rg-282 (Rg-280, 281 also)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(112, 173); // Cn-285
        MOST_COMMON_ISOTOPE_NEUTRONS.put(113, 173); // Nh-286 (Nh-284, 285 also)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(114, 175); // Fl-289
        MOST_COMMON_ISOTOPE_NEUTRONS.put(115, 175); // Mc-290 (Mc-288, 289 also)
        MOST_COMMON_ISOTOPE_NEUTRONS.put(116, 177); // Lv-293
        MOST_COMMON_ISOTOPE_NEUTRONS.put(117, 177); // Ts-294
        MOST_COMMON_ISOTOPE_NEUTRONS.put(118, 176); // Og-294
        MOST_COMMON_ISOTOPE_NEUTRONS.put(119, 184);
        MOST_COMMON_ISOTOPE_NEUTRONS.put(120, 184);

        // Populate VALID_ISOTOPE_NEUTRON_RANGES {min_neutrons, max_neutrons}
        // Based on known isotopes (lightest to heaviest observed, approximately)
        VALID_ISOTOPE_NEUTRON_RANGES.put(1, new int[]{0, 6}); // H-1 to H-7
        VALID_ISOTOPE_NEUTRON_RANGES.put(2, new int[]{0, 8}); // He-2 (2p) to He-10
        VALID_ISOTOPE_NEUTRON_RANGES.put(3, new int[]{1, 10}); // Li-4 to Li-13
        VALID_ISOTOPE_NEUTRON_RANGES.put(4, new int[]{2, 12}); // Be-6 to Be-16
        VALID_ISOTOPE_NEUTRON_RANGES.put(5, new int[]{2, 16}); // B-7 to B-21
        VALID_ISOTOPE_NEUTRON_RANGES.put(6, new int[]{2, 18}); // C-8 to C-24
        VALID_ISOTOPE_NEUTRON_RANGES.put(7, new int[]{3, 20}); // N-10 to N-27
        VALID_ISOTOPE_NEUTRON_RANGES.put(8, new int[]{4, 20}); // O-12 to O-28
        VALID_ISOTOPE_NEUTRON_RANGES.put(9, new int[]{5, 24}); // F-14 to F-33
        VALID_ISOTOPE_NEUTRON_RANGES.put(10, new int[]{6, 28}); // Ne-16 to Ne-38
        VALID_ISOTOPE_NEUTRON_RANGES.put(11, new int[]{7, 28}); // Na-18 to Na-39
        VALID_ISOTOPE_NEUTRON_RANGES.put(12, new int[]{8, 32}); // Mg-20 to Mg-44
        VALID_ISOTOPE_NEUTRON_RANGES.put(13, new int[]{9, 33}); // Al-22 to Al-46
        VALID_ISOTOPE_NEUTRON_RANGES.put(14, new int[]{10, 36}); // Si-24 to Si-50
        VALID_ISOTOPE_NEUTRON_RANGES.put(15, new int[]{11, 37}); // P-26 to P-52
        VALID_ISOTOPE_NEUTRON_RANGES.put(16, new int[]{12, 40}); // S-28 to S-52
        VALID_ISOTOPE_NEUTRON_RANGES.put(17, new int[]{13, 41}); // Cl-30 to Cl-58
        VALID_ISOTOPE_NEUTRON_RANGES.put(18, new int[]{14, 42}); // Ar-32 to Ar-60
        VALID_ISOTOPE_NEUTRON_RANGES.put(19, new int[]{16, 43}); // K-35 to K-62
        VALID_ISOTOPE_NEUTRON_RANGES.put(20, new int[]{18, 46}); // Ca-38 to Ca-66
        VALID_ISOTOPE_NEUTRON_RANGES.put(21, new int[]{19, 47}); // Sc-40 to Sc-68
        VALID_ISOTOPE_NEUTRON_RANGES.put(22, new int[]{20, 48}); // Ti-42 to Ti-70
        VALID_ISOTOPE_NEUTRON_RANGES.put(23, new int[]{21, 49}); // V-44 to V-72
        VALID_ISOTOPE_NEUTRON_RANGES.put(24, new int[]{22, 50}); // Cr-46 to Cr-74
        VALID_ISOTOPE_NEUTRON_RANGES.put(25, new int[]{23, 51}); // Mn-48 to Mn-76
        VALID_ISOTOPE_NEUTRON_RANGES.put(26, new int[]{24, 52}); // Fe-50 to Fe-78
        VALID_ISOTOPE_NEUTRON_RANGES.put(27, new int[]{25, 53}); // Co-52 to Co-80
        VALID_ISOTOPE_NEUTRON_RANGES.put(28, new int[]{26, 54}); // Ni-54 to Ni-82
        VALID_ISOTOPE_NEUTRON_RANGES.put(29, new int[]{28, 55}); // Cu-57 to Cu-84
        VALID_ISOTOPE_NEUTRON_RANGES.put(30, new int[]{30, 58}); // Zn-60 to Zn-88
        VALID_ISOTOPE_NEUTRON_RANGES.put(31, new int[]{31, 61}); // Ga-62 to Ga-92
        VALID_ISOTOPE_NEUTRON_RANGES.put(32, new int[]{32, 62}); // Ge-64 to Ge-94
        VALID_ISOTOPE_NEUTRON_RANGES.put(33, new int[]{34, 63}); // As-67 to As-96
        VALID_ISOTOPE_NEUTRON_RANGES.put(34, new int[]{35, 64}); // Se-69 to Se-98
        VALID_ISOTOPE_NEUTRON_RANGES.put(35, new int[]{37, 67}); // Br-72 to Br-102
        VALID_ISOTOPE_NEUTRON_RANGES.put(36, new int[]{38, 68}); // Kr-74 to Kr-104
        VALID_ISOTOPE_NEUTRON_RANGES.put(37, new int[]{40, 71}); // Rb-77 to Rb-108
        VALID_ISOTOPE_NEUTRON_RANGES.put(38, new int[]{41, 72}); // Sr-79 to Sr-110
        VALID_ISOTOPE_NEUTRON_RANGES.put(39, new int[]{43, 73}); // Y-82 to Y-112
        VALID_ISOTOPE_NEUTRON_RANGES.put(40, new int[]{44, 76}); // Zr-84 to Zr-116
        VALID_ISOTOPE_NEUTRON_RANGES.put(41, new int[]{46, 77}); // Nb-87 to Nb-118
        VALID_ISOTOPE_NEUTRON_RANGES.put(42, new int[]{47, 80}); // Mo-89 to Mo-122
        VALID_ISOTOPE_NEUTRON_RANGES.put(43, new int[]{48, 81}); // Tc-91 to Tc-124
        VALID_ISOTOPE_NEUTRON_RANGES.put(44, new int[]{50, 82}); // Ru-94 to Ru-126
        VALID_ISOTOPE_NEUTRON_RANGES.put(45, new int[]{51, 83}); // Rh-96 to Rh-128
        VALID_ISOTOPE_NEUTRON_RANGES.put(46, new int[]{52, 84}); // Pd-98 to Pd-130
        VALID_ISOTOPE_NEUTRON_RANGES.put(47, new int[]{54, 87}); // Ag-101 to Ag-134
        VALID_ISOTOPE_NEUTRON_RANGES.put(48, new int[]{56, 88}); // Cd-104 to Cd-136
        VALID_ISOTOPE_NEUTRON_RANGES.put(49, new int[]{57, 89}); // In-106 to In-138
        VALID_ISOTOPE_NEUTRON_RANGES.put(50, new int[]{58, 92}); // Sn-108 to Sn-142
        VALID_ISOTOPE_NEUTRON_RANGES.put(51, new int[]{60, 93}); // Sb-111 to Sb-144
        VALID_ISOTOPE_NEUTRON_RANGES.put(52, new int[]{61, 94}); // Te-113 to Te-146
        VALID_ISOTOPE_NEUTRON_RANGES.put(53, new int[]{63, 97}); // I-116 to I-150
        VALID_ISOTOPE_NEUTRON_RANGES.put(54, new int[]{64, 98}); // Xe-118 to Xe-152
        VALID_ISOTOPE_NEUTRON_RANGES.put(55, new int[]{66, 100}); // Cs-121 to Cs-155
        VALID_ISOTOPE_NEUTRON_RANGES.put(56, new int[]{68, 100}); // Ba-124 to Ba-156
        VALID_ISOTOPE_NEUTRON_RANGES.put(57, new int[]{70, 101}); // La-127 to La-158
        VALID_ISOTOPE_NEUTRON_RANGES.put(58, new int[]{72, 102}); // Ce-130 to Ce-160
        VALID_ISOTOPE_NEUTRON_RANGES.put(59, new int[]{73, 103}); // Pr-132 to Pr-162
        VALID_ISOTOPE_NEUTRON_RANGES.put(60, new int[]{74, 106}); // Nd-134 to Nd-166
        VALID_ISOTOPE_NEUTRON_RANGES.put(61, new int[]{76, 107}); // Pm-137 to Pm-168
        VALID_ISOTOPE_NEUTRON_RANGES.put(62, new int[]{78, 108}); // Sm-140 to Sm-170
        VALID_ISOTOPE_NEUTRON_RANGES.put(63, new int[]{79, 110}); // Eu-142 to Eu-173
        VALID_ISOTOPE_NEUTRON_RANGES.put(64, new int[]{80, 110}); // Gd-144 to Gd-174
        VALID_ISOTOPE_NEUTRON_RANGES.put(65, new int[]{82, 111}); // Tb-147 to Tb-176
        VALID_ISOTOPE_NEUTRON_RANGES.put(66, new int[]{84, 114}); // Dy-150 to Dy-180
        VALID_ISOTOPE_NEUTRON_RANGES.put(67, new int[]{86, 115}); // Ho-153 to Ho-182
        VALID_ISOTOPE_NEUTRON_RANGES.put(68, new int[]{87, 116}); // Er-155 to Er-184
        VALID_ISOTOPE_NEUTRON_RANGES.put(69, new int[]{89, 117}); // Tm-158 to Tm-186
        VALID_ISOTOPE_NEUTRON_RANGES.put(70, new int[]{90, 118}); // Yb-160 to Yb-188
        VALID_ISOTOPE_NEUTRON_RANGES.put(71, new int[]{92, 119}); // Lu-163 to Lu-190
        VALID_ISOTOPE_NEUTRON_RANGES.put(72, new int[]{93, 122}); // Hf-165 to Hf-194
        VALID_ISOTOPE_NEUTRON_RANGES.put(73, new int[]{95, 123}); // Ta-168 to Ta-196
        VALID_ISOTOPE_NEUTRON_RANGES.put(74, new int[]{96, 124}); // W-170 to W-198
        VALID_ISOTOPE_NEUTRON_RANGES.put(75, new int[]{98, 125}); // Re-173 to Re-200
        VALID_ISOTOPE_NEUTRON_RANGES.put(76, new int[]{100, 126}); // Os-176 to Os-202
        VALID_ISOTOPE_NEUTRON_RANGES.put(77, new int[]{101, 127}); // Ir-178 to Ir-204
        VALID_ISOTOPE_NEUTRON_RANGES.put(78, new int[]{102, 130}); // Pt-180 to Pt-208
        VALID_ISOTOPE_NEUTRON_RANGES.put(79, new int[]{104, 131}); // Au-183 to Au-210
        VALID_ISOTOPE_NEUTRON_RANGES.put(80, new int[]{106, 132}); // Hg-186 to Hg-212
        VALID_ISOTOPE_NEUTRON_RANGES.put(81, new int[]{108, 135}); // Tl-189 to Tl-216
        VALID_ISOTOPE_NEUTRON_RANGES.put(82, new int[]{110, 136}); // Pb-192 to Pb-218
        VALID_ISOTOPE_NEUTRON_RANGES.put(83, new int[]{112, 137}); // Bi-195 to Bi-220
        VALID_ISOTOPE_NEUTRON_RANGES.put(84, new int[]{112, 139}); // Po-196 to Po-223
        VALID_ISOTOPE_NEUTRON_RANGES.put(85, new int[]{115, 140}); // At-200 to At-225
        VALID_ISOTOPE_NEUTRON_RANGES.put(86, new int[]{116, 142}); // Rn-202 to Rn-228
        VALID_ISOTOPE_NEUTRON_RANGES.put(87, new int[]{120, 144}); // Fr-207 to Fr-231
        VALID_ISOTOPE_NEUTRON_RANGES.put(88, new int[]{122, 146}); // Ra-210 to Ra-234
        VALID_ISOTOPE_NEUTRON_RANGES.put(89, new int[]{124, 147}); // Ac-213 to Ac-236
        VALID_ISOTOPE_NEUTRON_RANGES.put(90, new int[]{126, 150}); // Th-216 to Th-240
        VALID_ISOTOPE_NEUTRON_RANGES.put(91, new int[]{128, 151}); // Pa-219 to Pa-242
        VALID_ISOTOPE_NEUTRON_RANGES.put(92, new int[]{130, 152}); // U-222 to U-244
        VALID_ISOTOPE_NEUTRON_RANGES.put(93, new int[]{132, 153}); // Np-225 to Np-246
        VALID_ISOTOPE_NEUTRON_RANGES.put(94, new int[]{134, 155}); // Pu-228 to Pu-249
        VALID_ISOTOPE_NEUTRON_RANGES.put(95, new int[]{136, 156}); // Am-231 to Am-251
        VALID_ISOTOPE_NEUTRON_RANGES.put(96, new int[]{138, 158}); // Cm-234 to Cm-254
        VALID_ISOTOPE_NEUTRON_RANGES.put(97, new int[]{140, 159}); // Bk-237 to Bk-256
        VALID_ISOTOPE_NEUTRON_RANGES.put(98, new int[]{142, 160}); // Cf-240 to Cf-258
        VALID_ISOTOPE_NEUTRON_RANGES.put(99, new int[]{144, 161}); // Es-243 to Es-260
        VALID_ISOTOPE_NEUTRON_RANGES.put(100, new int[]{146, 162}); // Fm-246 to Fm-262
        VALID_ISOTOPE_NEUTRON_RANGES.put(101, new int[]{148, 163}); // Md-249 to Md-264
        VALID_ISOTOPE_NEUTRON_RANGES.put(102, new int[]{149, 164}); // No-251 to No-266
        VALID_ISOTOPE_NEUTRON_RANGES.put(103, new int[]{151, 165}); // Lr-254 to Lr-268
        VALID_ISOTOPE_NEUTRON_RANGES.put(104, new int[]{153, 167}); // Rf-257 to Rf-271
        VALID_ISOTOPE_NEUTRON_RANGES.put(105, new int[]{154, 169}); // Db-259 to Db-274
        VALID_ISOTOPE_NEUTRON_RANGES.put(106, new int[]{156, 170}); // Sg-262 to Sg-276
        VALID_ISOTOPE_NEUTRON_RANGES.put(107, new int[]{157, 171}); // Bh-264 to Bh-278
        VALID_ISOTOPE_NEUTRON_RANGES.put(108, new int[]{158, 173}); // Hs-266 to Hs-281
        VALID_ISOTOPE_NEUTRON_RANGES.put(109, new int[]{160, 173}); // Mt-269 to Mt-282
        VALID_ISOTOPE_NEUTRON_RANGES.put(110, new int[]{161, 175}); // Ds-271 to Ds-285 (Ds-281 is common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(111, new int[]{163, 175}); // Rg-274 to Rg-286 (Rg-282 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(112, new int[]{165, 177}); // Cn-277 to Cn-289 (Cn-285 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(113, new int[]{167, 177}); // Nh-280 to Nh-290 (Nh-286 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(114, new int[]{169, 179}); // Fl-283 to Fl-293 (Fl-289 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(115, new int[]{171, 180}); // Mc-286 to Mc-295 (Mc-290 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(116, new int[]{173, 181}); // Lv-289 to Lv-297 (Lv-293 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(117, new int[]{175, 181}); // Ts-292 to Ts-298 (Ts-294 common reference)
        VALID_ISOTOPE_NEUTRON_RANGES.put(118, new int[]{175, 180}); // Og-293 to Og-298 (Og-294 common reference, Og-295 might be theoretical)
        // Using observed Og-293, Og-294, possibly Og-295; (293-118)=175, (294-118)=176, (295-118)=177
        VALID_ISOTOPE_NEUTRON_RANGES.put(118, new int[]{175, 177}); // Og, based on isotopes like 293, 294, 295
        VALID_ISOTOPE_NEUTRON_RANGES.put(119, new int[]{172, 191});
        VALID_ISOTOPE_NEUTRON_RANGES.put(120, new int[]{172, 192});
    }
}